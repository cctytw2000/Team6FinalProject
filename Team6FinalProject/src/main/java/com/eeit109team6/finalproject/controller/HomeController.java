package com.eeit109team6.finalproject.controller;

import java.util.List;

import javax.servlet.ServletContext;
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

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberDetail;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.ProductService;

@Controller
public class HomeController {
//	IMemberService service;
	ProductService service;
	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

//	@Autowired
//	public void setService(IMemberService service) {
//		this.service = service;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {

//		List<Product> list = service.getAllProducts();
//		session.setAttribute("products", list);

		return "home";
	}

	@RequestMapping(value = "/member/insertMemberInformationform", method = RequestMethod.GET)
	public String insertMemberInformationForm(@RequestParam("id") Integer memberid, @RequestParam("token") String token,
			Model model) {

		MemberDetail md = new MemberDetail();
		md.setAddress("美國");
		md.setToken(token);
		md.setId(memberid);

		model.addAttribute("MemberDetail", md);

		return "insertMemberDetail";
	}

	@RequestMapping(value = "/member/insertThirdPartyMemberInformationform", method = RequestMethod.GET)
	public String insertThirdPartyMemberInformationform(@RequestParam("id") Integer memberid,
			@RequestParam("type") String type, @RequestParam("username") String username, Model model) {

		MemberDetail md = new MemberDetail();
		md.setUsername(username);
		md.setId(memberid);
		md.setType(type);
		model.addAttribute("MemberDetail", md);

		return "insertMemberDetail";
	}

}
