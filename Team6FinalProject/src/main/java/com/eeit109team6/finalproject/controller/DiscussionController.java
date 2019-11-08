package com.eeit109team6.finalproject.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.service.IDiscussionService;

@Controller
public class DiscussionController {

	public DiscussionController() {
	}

	IDiscussionService service;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(IDiscussionService service) {
		this.service = service;
	}

	//查詢所有文章。  開發當前階段的討論區主頁
	@RequestMapping("/discussion")
	public String getAllArticles(Model model) {
		List<Discussion> list = service.getAllArticles();
		model.addAttribute(list);//discussionList  不給定名字，則以物件首字小寫+List。也支援Map
		return "showDiscussion";
	}
	
	//查詢單一主題
	//要改為查詢討論串
	@RequestMapping("/article")
		public String getArticleById(Model model,
				@RequestParam("id") Integer articleId,  
				HttpSession session,
				HttpServletRequest request) {
		System.out.print("articleId======" + articleId);
//		Discussion d = new Discussion();
//		d.setArticleId(articleId);
//		Discussion discussion = service.getArticleById(articleId);
		model.addAttribute("discussion", service.getArticleById(articleId));
		return "article";
	}
	
	
	
	
}
