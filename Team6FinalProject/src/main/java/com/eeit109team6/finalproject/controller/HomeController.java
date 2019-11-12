package com.eeit109team6.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.HomeMovie;
import com.eeit109team6.finalproject.model.LiLoInfo;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MemberDetail;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IHomeMovieService;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.ProductService;

@Controller
public class HomeController {
//	IMemberService service;
	ProductService service;
	IHomeMovieService movieService;

	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setMovieService(IHomeMovieService movieService) {
		this.movieService = movieService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		HomeMovie home = movieService.findById(1);

		List<Product> list = service.getProductTop8();
		session.setAttribute("productsTop8", list);

		model.addAttribute("homeMovie", home);
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

//	@RequestMapping(value = "/homeMovie/{id}.json")
//	public String homeMovie(@PathVariable("id") Integer id, Model model) {
//		HomeMovie home = movieService.findById(id);
//		model.addAttribute(home);
//		return "MovieBack";
//
//	}

}
