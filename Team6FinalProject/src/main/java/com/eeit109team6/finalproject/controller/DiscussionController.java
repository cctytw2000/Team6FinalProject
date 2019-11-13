package com.eeit109team6.finalproject.controller;

import java.util.List;

import javax.servlet.ServletContext;

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
	public void setDiscussionService(IDiscussionService service) {
		this.discussionService = service;
	}

	@Autowired
	public void setBoardTypeService(IBoardTypeService boardTypeService) {
		this.boardTypeService = boardTypeService;
	}
	
	// 討論區主頁:查詢所有看板 --> showDiscussion.jsp
	@RequestMapping("/discussion")
	public String getAllBoardType(Model model) {
		//boardTypeService實作方法向DAO取得所有看板的值，將其設給BoardType型態的物件組成的串列
		List<BoardType> list = boardTypeService.getAllBoardType();
		System.out.println("抓取看板列表");
		model.addAttribute(list);
		return "showDiscussion";
	}
	
	// 本方法停止使用
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
		List<Discussion> Discussionlist = discussionService.getArticleByBoardTypeId(boardId);
		BoardType boardType = boardTypeService.getBoardTypeById(boardId);
		
		model.addAttribute("DiscussionList", Discussionlist);//discussionList  不給定名字，則用物件首字小寫+型態首字大寫List。
		model.addAttribute("boardType",boardType);
		
		//將service實作類別取得的物件，設給Spring提供的Model介面的model物件
		//Spring提供的注入集合功能，支援List、Map、Properties、Set四種集合。ref:王本p48
		
	return "board";
	}
	
	//查詢單一文章 --> article.jsp
//	HttpSession session,
//	HttpServletRequest request
	@RequestMapping("/article")
		public String getArticleById(Model model,
				@RequestParam("id") Integer articleId
				) {
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
	
	//	 ============施工中============
	//	 提供新增文章時的表單 --> addArticle.jsp 
	//	 傳進來時，就必須要有boardId 板塊編號。
	//	 新增文章按鈕，必須擺在board.jsp當中
//		@RequestMapping(value = "addArticle", method = RequestMethod.GET)
//		public String getAddArticleForm(@RequestParam("id") Integer boardId,
//										Model model) {
//			System.out.println("進入getAddArticleForm()方法");
//			//宣告一個Discussion類別的物件discussion，且以該類別的建構子建立一個Discussion實體，且將該實體指定給前者
//			Discussion discussion = new Discussion();	
//			//將discussion物件(代表一筆文章)設給model物件，識別字串為"discussion"
//			model.addAttribute("discussion", discussion);
//			//傳回視圖邏輯名稱 "addArticle"
//			return "addArticle";
//		}
	//	 ============施工中============
	//	 新增文章 -->重定向至所屬的討論看板  board.jsp
//		@RequestMapping(value = "addArticle", method = RequestMethod.POST)
//		public String processAddArticle(@ModelAttribute("boardType") BoardType bt) {
//			System.out.println("進入processAddArticle()方法");
//			boardTypeService.addBoardType(bt);
//			return "redirect:/board";
//		}
}
