package com.eeit109team6.finalproject.controller;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.service.IMovieService;


@Controller
public class MovieController {

	IMovieService service;
	
	@Autowired
	public void setService(IMovieService service) {
		this.service = service;
	}
	
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}
	
//	movieindex      撈出Page Section 的影片 
	@RequestMapping("/movies")
	public String findMovies(Model model, HttpSession session) {
		
		Member mem = new Member();
		
		mem.setAccount("sandy60108@yahoo.com.tw");
		mem.setPassword("a14789632");
		mem.setUsername("andy");
		
		List<MovieInfo> list = service.getMovieInfoByOwnerID();
		System.out.println("List<MovieInfo> list : "+list);
		model.addAttribute("movies", list);
		session.setAttribute("movies", list);
		model.addAttribute("Member", mem);
		return "movieindex";
	}
	
	   
}
