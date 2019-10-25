package com.eeit109team6.finalproject.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Properties;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eeit109team6.finalproject.javaUtils.AES_CBC_PKCS5PADDING;
import com.eeit109team6.finalproject.javaUtils.CipherUtils;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberDetail;
import com.eeit109team6.finalproject.service.IMemberService;

@Controller
public class MemberController {
	IMemberService service;
	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(IMemberService service) {
		this.service = service;
	}

	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("Member") Member mem, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException(
					"嘗試輸入錯誤的欄位:" + org.springframework.util.StringUtils.arrayToCommaDelimitedString(suppressedFields));

		}
		if (mem.getPassword() != null) {

			// ==============設定創建帳號時間=======================
			Calendar rightNow = Calendar.getInstance();
			String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":"
					+ rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND);
			// ==============/設定創建帳號時間=======================

			// ==============密碼加密=======================
			int isactive = 0;
			String key = "MickeyKittyLouis";
			String password_AES = CipherUtils.encryptString(key, mem.getPassword()).replaceAll("[\\pP\\p{Punct}]", "")
					.replace(" ", "");
			// ==============/密碼加密=======================

			// ==============設定token====================
			KeyGenerator keyGen;
			try {
				keyGen = KeyGenerator.getInstance("AES");
				keyGen.init(256, new SecureRandom());
				SecretKey secretKey = keyGen.generateKey();
				byte[] iv = new byte[16];
				SecureRandom prng = new SecureRandom();
				prng.nextBytes(iv);
				Long math = Long.valueOf((long) (Math.random() * 999999999));
				String token_notformat = AES_CBC_PKCS5PADDING.Encrypt(secretKey, iv, math.toString());
				String token = token_notformat.replaceAll("[\\pP\\p{Punct}]", "").replace(" ", "");
				mem.setToken(token);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// ==============/設定token====================

			mem.setPassword(password_AES);

			mem.setType("General");

			mem.setRegisteredtime(registeredtime);
			mem.setIsactive(0);

			Integer memberId = service.add(mem);
			String email = null;
			String pwd = null;

			try {
				BufferedReader bfr = new BufferedReader(new FileReader("C:\\sqldata\\sqldata.txt"));
				String data;
				while ((data = bfr.readLine()) != null) {
					email = data.split(",")[0];
					pwd = data.split(",")[1];
				}
				bfr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			final String Email = email;// your Gmail
			final String EmailPwd = pwd;// your password
			String host = "smtp.gmail.com";
			int port = 587;

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", port);
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Email, EmailPwd);
				}
			});

			try {

				String url = "http://" + request.getServerName() + ":" + request.getServerPort()
						+ request.getContextPath() + "/member/insertMemberInformationform?id=" + memberId + "&token="
						+ mem.getToken();
				System.out.println("url = " + url);
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(Email));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mem.getAccount()));
				message.setSubject("驗證信");
				message.setText(
						"Wellcome To FootBook \n" + "http://localhost:8080/Team6FinalProject/member/insertMemberIn"
								+ "formationform?id=" + memberId + "&token=" + mem.getToken());

				Transport transport = session.getTransport("smtp");
				transport.connect(host, port, Email, EmailPwd);

				Transport.send(message);

				System.out.println("寄送email結束.");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		}
		redirectAttributes.addFlashAttribute("msg", "請至您輸入的信箱收取驗證信<br>並輸入完整資料開通帳號");

		return "redirect:/jump";
	}

	@RequestMapping(value = "/jump")
	public String jumpWeb(Model model) {

		return "jump";
	}

	@InitBinder
	public void whiteListion(WebDataBinder binder) {
		binder.setAllowedFields("account", "password", "username");
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String memberLogin(@ModelAttribute("Member") Member mem, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session) {

		String key = "MickeyKittyLouis";
		String password_AES = CipherUtils.encryptString(key, mem.getPassword()).replaceAll("[\\pP\\p{Punct}]", "")
				.replace(" ", "");
		System.out.println("account:" + mem.getAccount());
		mem.setPassword(password_AES);
		mem.setType("General");

		Member member = service.login(mem);

		if (member != null) {
			session.setAttribute("username", member.getUsername());
			session.setAttribute("token", member.getToken());
			session.setAttribute("account", member.getAccount());
			session.setAttribute("member_id", member.getMember_id());
			session.setAttribute("mem", member);
			session.setAttribute("type", member.getType());
			redirectAttributes.addFlashAttribute("msg", "歡迎光臨Gamily");
			return "redirect:/jump";
		} else {
			System.out.println("member=" + member);
			redirectAttributes.addFlashAttribute("msg", "帳號密碼錯誤<br>請確認後再登入");
			return "redirect:/jump";

		}

	}

	@RequestMapping(value = "/member/logout")
	public String memberLogout(@ModelAttribute("Member") Member mem, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("token");
		session.removeAttribute("account");
		session.removeAttribute("member_id");
		session.removeAttribute("mem");
		session.removeAttribute("type");
		redirectAttributes.addFlashAttribute("msg", "謝謝光臨Gamily");
		return "redirect:/jump";

	}

}