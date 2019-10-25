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
import com.eeit109team6.finalproject.service.MemberDetailService;
import com.eeit109team6.finalproject.service.MemberService;

@Controller
public class MemberDetailController {
	MemberService MEMservice;
	ServletContext context;
	MemberDetailService MDservice;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(MemberService service) {
		this.MEMservice = service;
	}
	
	@Autowired
	public void setMDservice(MemberDetailService mDservice) {
		MDservice = mDservice;
	}

	@RequestMapping(value = "/member/insertMemberInformation", method = RequestMethod.POST)
	public String insertMemberInformation(@ModelAttribute("MemberDetail") MemberDetail md, Model model,
			RedirectAttributes redirectAttributes) {
		System.out.println("address:" + md.getAddress());
		System.out.println("sex:" + md.getSex());
		System.out.println("Birth:" + md.getBirth());
		System.out.println("Idnumber:" + md.getIdnumber());
		System.out.println("memberid:" + md.getId());
		System.out.println("token:" + md.getToken());
		Member mem = new Member();
		mem.setMember_id(md.getId());
		Member member = MEMservice.findById(mem);
		md.setMember(member);
		MDservice.add(md);
		redirectAttributes.addFlashAttribute("msg", "已完成輸入會員資料及開通帳號");

		return "redirect:/jump";
	}

}
