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

import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.service.IBoardTypeService;
import com.eeit109team6.finalproject.service.IDiscussionService;

@Controller
public class DiscussionController {

	public DiscussionController() {
	}

	IDiscussionService discussionService;
	IBoardTypeService boardTypeService;
	ServletContext context;
	
	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	@Autowired
	public void setService(IDiscussionService service) {
		this.discussionService = service;
	}

	@Autowired
	public void setBoardTypeService(IBoardTypeService boardTypeService) {
		this.boardTypeService = boardTypeService;
	}
	
	// 論區主頁:查詢所有看板 --> showDiscussion.jsp
	@RequestMapping("/discussion")
	public String getAllBoardType(Model model) {
		List<BoardType> list = boardTypeService.getAllBoardType();
		System.out.println("抓取看板列表");
		model.addAttribute(list);
		return "showDiscussion";
	}
	
	// 本方法暫不使用
	// 顯示全站討論區所有文章列表
//	@RequestMapping("/board")		
//	public String getAllArticles(Model model) {
//		List<Discussion> list = discussionService.getAllArticles();
//		model.addAttribute(list);//discussionList  不給定名字，則用物件首字小寫+型態首字大寫List。
//	return "board";
//	}
	
	// 進入指定看板，顯示指定看板的文章列表 --> board.jsp
	@RequestMapping("/board")		
	public String getArticleByBoardTypeId(@RequestParam("id") Integer boardId ,Model model) {
		List<Discussion> list = discussionService.getArticleByBoardTypeId(boardId);
		model.addAttribute(list);//discussionList  不給定名字，則用物件首字小寫+型態首字大寫List。
		//將service實作類別取得的物件，設給Spring提供的Model介面的model物件
		//Spring提供的注入集合功能，支援List、Map、Properties、Set四種集合。ref:王本p48
	return "board";
	}
	
	//查詢單一文章 --> article.jsp
	@RequestMapping("/article")
		public String getArticleById(Model model,
				@RequestParam("id") Integer articleId,  
				HttpSession session,
				HttpServletRequest request) {
		System.out.println("articleId:" + articleId);
//		Discussion d = new Discussion();
//		d.setArticleId(articleId);
		Discussion discussion = discussionService.getArticleById(articleId);
//		model.addAttribute("discussion", discussionService.getArticleById(articleId));
		model.addAttribute("discussion", discussion);
//		model.addAttribute("boardName", boardTypeService.getBoardTypeById(discussion.boardId));		
		
//		List<Reply> reply = discussionService.getReplyById(articleId);  //取得討論串
//		model.addAttribute("reply", reply);
//		String boardType = boardTypeService.getBoardTypeById(discussionService.getArticleById(articleId));

		return "article";
	}
	
	
	
	
}
