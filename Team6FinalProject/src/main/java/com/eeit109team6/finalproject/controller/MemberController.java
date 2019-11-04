package com.eeit109team6.finalproject.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eeit109team6.finalproject.javaUtils.AES_CBC_PKCS5PADDING;
import com.eeit109team6.finalproject.javaUtils.CipherUtils;
import com.eeit109team6.finalproject.javaUtils.Mail;
import com.eeit109team6.finalproject.model.LiLoInfo;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberLevel;
import com.eeit109team6.finalproject.service.ILiLoInforService;
import com.eeit109team6.finalproject.service.IMemberLevelService;
import com.eeit109team6.finalproject.service.IMemberService;

@Controller
public class MemberController {
	IMemberService MemService;
	ServletContext context;
	ILiLoInforService LiLoInforService;
	IMemberLevelService IMemberLevelService;

	@Autowired
	public void setIMemberLevelService(IMemberLevelService iMemberLevelService) {
		IMemberLevelService = iMemberLevelService;
	}

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setMemService(IMemberService memService) {
		MemService = memService;
	}

	@Autowired
	public void setLiLoInforService(ILiLoInforService liLoInforService) {
		LiLoInforService = liLoInforService;
	}

	@RequestMapping(value = "/member/register", method = RequestMethod.POST)
	public String registerMember(@RequestParam("account") String account, @RequestParam("password") String password,
			@RequestParam("username") String username, Model model, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
//		String[] suppressedFields = result.getSuppressedFields();

		Member mem = new Member();
//		if (suppressedFields.length > 0) {
//			throw new RuntimeException(
//					"嘗試輸入錯誤的欄位:" + org.springframework.util.StringUtils.arrayToCommaDelimitedString(suppressedFields));
//		}

		// ==============設定創建帳號時間=======================
		Calendar rightNow = Calendar.getInstance();
		String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定創建帳號時間=======================

		// ==============密碼加密=======================
		String key = "MickeyKittyLouis";
		String password_AES = CipherUtils.encryptString(key, password).replaceAll("[\\pP\\p{Punct}]", "").replace(" ",
				"");
		// ==============/密碼加密=======================

		MemberLevel level = IMemberLevelService.findById(2);
//		System.out.println("level==" + level.getLevelName());
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
		mem.setAccount(account);
		mem.setUsername(username);
		mem.setPassword(password_AES);

		mem.setType("General");
		mem.setMemberlevel(level);
		mem.setRegisteredtime(registeredtime);
		mem.setIsactive(0);
		Integer memberId = MemService.add(mem);
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

			e1.printStackTrace();
		}

		Mail mail = new Mail();
		mail.setEmail(email);
		mail.setPwd(pwd);
		Boolean isSuccess = mail.SendMessage(memberId, mem.getAccount(), mem.getToken());
		if (isSuccess) {
			System.out.println("寄送email結束.");
			redirectAttributes.addFlashAttribute("msg", "請至您輸入的信箱收取驗證信<br>並輸入完整資料開通帳號");
			return "redirect:/jump";
		} else {
			redirectAttributes.addFlashAttribute("msg", "有東西有問題喔");
			return "redirect:/jump";
		}

	}

	@RequestMapping(value = "/member/thirdPartyLogin", method = RequestMethod.POST)
	public @ResponseBody Boolean thirdPartyLogin(@RequestParam("account") String account,
			@RequestParam("type") String type, @RequestParam("username") String username, HttpSession session,
			HttpServletRequest request) {

		Member mem = new Member();

		String key = "MickeyKittyLouis";
		String password_AES = CipherUtils.encryptString(key, account).replaceAll("[\\pP\\p{Punct}]", "").replace(" ",
				"");

		mem.setAccount(account);
		mem.setPassword(password_AES);
		mem.setType(type);
		Member member = MemService.login(mem);

		LiLoInfo lilo = new LiLoInfo();
		// ==============設定創建帳號時間=======================
		Calendar rightNow = Calendar.getInstance();
		String logintime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定創建帳號時間=======================

		lilo.setMember(member);
		lilo.setLoginTime(logintime);
		lilo.setType("Login");
		lilo.setClientIP(request.getRemoteAddr());
		lilo.setAccountType(type);
//		System.out.println("member.getMemberlevel().getLevelName()"+member.getMemberlevel().getLevelName());
		if (member != null) {
			lilo.setIsSuccess(1);
			LiLoInforService.add(lilo);
			session.setAttribute("username", member.getUsername());
			session.setAttribute("token", member.getToken());
			session.setAttribute("account", member.getAccount());
			session.setAttribute("member_id", member.getMember_id());
			session.setAttribute("mem", member);
			session.setAttribute("type", member.getType());
			session.setAttribute("level", member.getMemberlevel().getLevelName());

			return true;
		} else {

			return false;

		}

	}

	@RequestMapping(value = "/member/thirdPartyRegister")
	public @ResponseBody Integer registerFacebookOrGoogleMember(@RequestParam("account") String account,
			@RequestParam("type") String type, @RequestParam("username") String username) {

		Member mem = new Member();
		// ==============設定創建帳號時間=======================
		Calendar rightNow = Calendar.getInstance();
		String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定創建帳號時間=======================

		// ==============密碼加密=======================

		String key = "MickeyKittyLouis";
		String password_AES = CipherUtils.encryptString(key, account).replaceAll("[\\pP\\p{Punct}]", "").replace(" ",
				"");
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

		MemberLevel level = IMemberLevelService.findById(2);
		mem.setAccount(account);
		mem.setPassword(password_AES);
		mem.setPassword(password_AES);
		mem.setUsername(username);
		mem.setType(type);
		mem.setMemberlevel(level);
		mem.setRegisteredtime(registeredtime);
		mem.setIsactive(0);

		int memberId = MemService.add(mem);

		return memberId;

	}

	@RequestMapping(value = "/member/checkRepeat")
	public @ResponseBody Boolean checkRepeatFacebookOrGoogleMember(@RequestParam("account") String account,
			@RequestParam("type") String type) {
		System.out.println("/member/checkRepeat");
		System.out.println("account=" + account);
		System.out.println("type=" + type);
		Member mem = new Member();
		mem.setAccount(account);
		mem.setType(type);
		boolean repeatAnswer = MemService.checkAccount(mem);
		System.out.println("repeatAnswer" + repeatAnswer);
		return repeatAnswer;
	}

	@RequestMapping(value = "/member/checkGeneralRepeat")
	public @ResponseBody Boolean checkGeneralRepeat(@RequestParam("account") String account,
			@RequestParam("type") String type) {
		System.out.println("/member/checkRepeat");
		System.out.println("account=" + account);
		System.out.println("type=" + type);
		Member mem = new Member();
		mem.setAccount(account);
		mem.setType(type);
		boolean repeatAnswer = MemService.checkAccount(mem);
		System.out.println("repeatAnswer" + repeatAnswer);
		return repeatAnswer;
	}

	@RequestMapping(value = "/member/changeActive", method = RequestMethod.POST)
	public @ResponseBody Boolean changeActive(@RequestParam("id") Integer id, @RequestParam("type") String type,
			@RequestParam("action") String action) {
		System.out.println("id=" + id);
		System.out.println("type=" + type);
		System.out.println("action=" + action);
		if ("close".equals(action)) {
			MemService.closeActive(id);
			return true;
		} else {
			MemService.openActive(id);
			return true;
		}

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
	public String memberLogin(@RequestParam("login") String login, @RequestParam("loginpassword") String password,
			@RequestParam("loginaccount") String account, Model model, RedirectAttributes redirectAttributes,
			HttpSession session, HttpServletRequest request) {
		System.out.println("他點的是" + login);

		Member mem = new Member();
		mem.setAccount(account);
		mem.setPassword(password);
		if ("登入".equals(login)) {

			String key = "MickeyKittyLouis";
			String password_AES = CipherUtils.encryptString(key, mem.getPassword()).replaceAll("[\\pP\\p{Punct}]", "")
					.replace(" ", "");

			mem.setPassword(password_AES);
			mem.setType("General");

			Member member = MemService.login(mem);

			LiLoInfo lilo = new LiLoInfo();
//			System.out.println("LiLo============================" + member.getLiLoInfo().size());
			// ==============設定登入帳號時間=======================
			Calendar rightNow = Calendar.getInstance();
			String logintime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
					+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":"
					+ rightNow.get(Calendar.MINUTE) + ":" + rightNow.get(Calendar.SECOND);
			// ==============/設定登入帳號時間=======================

			lilo.setMember(member);
			lilo.setLoginTime(logintime);
			lilo.setType("Login");
			lilo.setClientIP(request.getRemoteAddr());
			lilo.setAccountType("General");
			lilo.setIsSuccess(1);

			if (member != null) {
				LiLoInforService.add(lilo);
				session.setAttribute("username", member.getUsername());
				session.setAttribute("token", member.getToken());
				session.setAttribute("account", member.getAccount());
				session.setAttribute("member_id", member.getMember_id());
				session.setAttribute("mem", member);
				session.setAttribute("type", member.getType());

				session.setAttribute("level", member.getMemberlevel().getLevelName());
				redirectAttributes.addFlashAttribute("msg", "歡迎光臨Gamily");
				return "redirect:/jump";
			} else {
				member = MemService.checkAccount(mem.getAccount());

				lilo.setIsSuccess(0);
				lilo.setMember(member);
				LiLoInforService.add(lilo);
				redirectAttributes.addFlashAttribute("msg", "帳號密碼錯誤<br>請確認後再登入");
				return "redirect:/jump";

			}
		} else {
			model.addAttribute("msg", "忘記密碼");
			return "forgetPassWord";

		}

	}

	@RequestMapping(value = "/member/sendChangePassWordMail", method = RequestMethod.GET)
	public String sendChangePassWordMail(Model model) {
		model.addAttribute("msg", "修改密碼");

		return "forgetPassWord";

	}

	@RequestMapping(value = "/member/sendChangePassWordPage", method = RequestMethod.POST)
	public String sendChangePassWord(@RequestParam("account") String account, Model model,
			RedirectAttributes redirectAttributes, HttpSession session) {
//		System.out.println("account=" + account);
		String changeType, type;
		if (session.getAttribute("account") == null) {
			changeType = "忘記密碼";
			type = "forget";
		} else {
			changeType = "修改密碼";
			type = "change";
		}
		System.out.println("忘記密碼");
		Member mem = new Member();
		mem.setAccount(account);
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
			mem.setType("General");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean forget = MemService.forgetPwd(mem);

		if (forget) {
			String email = null;
			String pwd = null;

			BufferedReader bfr;
			try {
				bfr = new BufferedReader(new FileReader("C:\\sqldata\\sqldata.txt"));
				String data;

				while ((data = bfr.readLine()) != null) {
					System.out.println(data);
					email = data.split(",")[0];
					pwd = data.split(",")[1];
				}

				bfr.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			String host = "smtp.gmail.com";
			int port = 587;
			final String Email = email;// your Gmail
			final String EmailPwd = pwd;// your password

			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", port);
			Session session_ = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(Email, EmailPwd);
				}
			});

			try {

				Message message = new MimeMessage(session_);
				message.setFrom(new InternetAddress(Email));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mem.getAccount()));

				String url = "http://localhost:8080/Team6FinalProject/member/InsertNewPassowrd?account="
						+ mem.getAccount() + "&token=" + mem.getToken() + "&type=" + type;

				message.setSubject(changeType);
				message.setText("please click this url to change your password\n" + url);

				Transport transport = session_.getTransport("smtp");
				transport.connect(host, port, Email, EmailPwd);

				Transport.send(message);

				System.out.println("寄送email結束.");
				redirectAttributes.addFlashAttribute("msg", "請至您的電子郵件<br>點擊連結修改密碼");

				return "redirect:/jump";

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		} else {
			redirectAttributes.addFlashAttribute("msg", "沒有此帳號，或者您註冊的帳號為FB、Google帳號");

			return "redirect:/jump";
		}

	}

	@RequestMapping(value = "/member/logout")
	public String memberLogout(@ModelAttribute("Member") Member mem, Model model, BindingResult result,
			RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
		Member member_ = new Member();
		member_.setMember_id(Integer.parseInt(String.valueOf(session.getAttribute("member_id"))));
		Member member = MemService.findById(member_);

		LiLoInfo lilo = new LiLoInfo();
//		System.out.println("LiLo============================" + member.getLiLoInfo().size());
		// ==============設定登出帳號時間=======================
		Calendar rightNow = Calendar.getInstance();
		String logouttime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定登出帳號時間=======================

		lilo.setMember(member);
		lilo.setLoginTime(logouttime);
		lilo.setType("Logout");
		lilo.setClientIP(request.getRemoteAddr());
		lilo.setAccountType(String.valueOf(session.getAttribute("type")));
		lilo.setIsSuccess(1);

		LiLoInforService.add(lilo);

		session.removeAttribute("username");
		session.removeAttribute("token");
		session.removeAttribute("account");
		session.removeAttribute("member_id");
		session.removeAttribute("mem");
		session.removeAttribute("type");
		redirectAttributes.addFlashAttribute("msg", "謝謝光臨Gamily");
		return "redirect:/jump";

	}

	@RequestMapping(value = "/member/InsertNewPassowrd", method = RequestMethod.GET)
	public String insertNewPassWrod(@RequestParam("account") String account, @RequestParam("type") String type,
			@RequestParam("token") String token, Model model, RedirectAttributes redirectAttributes) {

		System.out.println("account:" + account);
		System.out.println("token:" + token);
		System.out.println("type:" + type);

//		redirectAttributes.addFlashAttribute("msg", "謝謝光臨Gamily");
		model.addAttribute("token", token);
		model.addAttribute("account", account);
		model.addAttribute("type", type);
		return "InsertNewPassowrd";

	}

	@RequestMapping(value = "/member/ChangeNewPassowrd", method = RequestMethod.POST)
	public String ChangeNewPassowrd(@RequestParam("account") String account, @RequestParam("token") String token,
			@RequestParam("newPassWord") String newPassWord, @RequestParam("oldpassword") String oldPassWord,
			Model model, RedirectAttributes redirectAttributes) {
		if ("Null".equals(oldPassWord)) {
			Member mem = new Member();
//			System.out.println("account:" + account);
//			System.out.println("token:" + token);
//			System.out.println("newPassWord:" + newPassWord);

			// ==============密碼加密=======================

			String key = "MickeyKittyLouis";
			String password_AES = CipherUtils.encryptString(key, newPassWord).replaceAll("[\\pP\\p{Punct}]", "")
					.replace(" ", "");
			// ==============/密碼加密=======================

			mem.setAccount(account);
			mem.setToken(token);
			mem.setType("General");
			mem.setPassword(password_AES);
			Boolean isSuccess = MemService.changePwd(mem);
			if (isSuccess) {
				redirectAttributes.addFlashAttribute("msg", "修改成功\n請依照新密碼登入");
				return "redirect:/jump";
			} else {

				redirectAttributes.addFlashAttribute("msg", "資訊錯誤請重新輸入");
				return "redirect:/jump";
			}
		} else {
			Member mem = new Member();
			System.out.println("account:" + account);
			System.out.println("token:" + token);
			System.out.println("oldPassWord:" + oldPassWord);
			System.out.println("newPassWord:" + newPassWord);

			String key = "MickeyKittyLouis";
			String password_AES = CipherUtils.encryptString(key, oldPassWord).replaceAll("[\\pP\\p{Punct}]", "")
					.replace(" ", "");
			// ==============/舊密碼加密=======================

			// ==============新密碼密碼加密=======================

			String new_password_AES = CipherUtils.encryptString(key, newPassWord).replaceAll("[\\pP\\p{Punct}]", "")
					.replace(" ", "");
			// ==============/密碼加密=======================

			mem.setAccount(account);
			mem.setToken(token);
			mem.setType("General");
			mem.setPassword(password_AES);
			Boolean isSuccess = MemService.changePwd(mem, new_password_AES);
			if (isSuccess) {
				redirectAttributes.addFlashAttribute("msg", "修改成功\n請依照新密碼登入");
				return "redirect:/jump";
			} else {

				redirectAttributes.addFlashAttribute("msg", "資訊錯誤請重新輸入");
				return "redirect:/jump";
			}

		}

	}

	@RequestMapping(value = "/membersBack")
	public String memberBack(Model model, HttpSession session, HttpServletRequest request) {

		ArrayList<Member> member = MemService.findAll();
		model.addAttribute("Memners", member);

		return "membersBack";

	}

	@RequestMapping(value = "/member")
	public String memberBack(@RequestParam("id") Integer id, Model model, HttpSession session,
			HttpServletRequest request) {
		System.out.println("id" + id);
		Member m = new Member();
		m.setMember_id(id);
		Member member = MemService.findById(m);
		model.addAttribute("member", member);
		return "memberBack";

	}

}