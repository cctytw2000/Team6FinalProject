package com.eeit109team6.finalproject.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberDetail;
import com.eeit109team6.finalproject.service.IMemberDetailService;
import com.eeit109team6.finalproject.service.IMemberService;

@Controller
public class MemberDetailController {
	IMemberService MEMservice;
	ServletContext context;
	IMemberDetailService MDservice;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(IMemberService service) {
		this.MEMservice = service;
	}

	@Autowired
	public void setMDservice(IMemberDetailService mDservice) {
		MDservice = mDservice;
	}

	@RequestMapping(value = "/member/insertMemberInformation", method = RequestMethod.POST)
	public String insertMemberInformation(@ModelAttribute("MemberDetail") MemberDetail md, Model model,
			RedirectAttributes redirectAttributes) {
//		System.out.println("address:" + md.getAddress());
//		System.out.println("sex:" + md.getSex());
//		System.out.println("Birth:" + md.getBirth());
//		System.out.println("Idnumber:" + md.getIdnumber());
//		System.out.println("memberid:" + md.getId());
		System.out.println("token:" + md.getToken());
		if (md.getToken() != null) {
			Member mem = new Member();
			mem.setMember_id(md.getId());
			Member member = MEMservice.findById(mem);
			MEMservice.openActive(member);
			md.setMember(member);
			MDservice.add(md);
			System.out.println("普通會員帳號開通填資料完畢");
			redirectAttributes.addFlashAttribute("msg", "已完成輸入會員資料及開通帳號");
			return "redirect:/jump";
		} else {
			Member mem = new Member();
			mem.setMember_id(md.getId());
			Member member = MEMservice.findById(mem);
			MEMservice.openActive(member);
			md.setMember(member);
			MDservice.add(md);
			redirectAttributes.addFlashAttribute("msg", "已完成輸入會員資料及開通帳號");
			return "redirect:/jump";

		}

	}

}
