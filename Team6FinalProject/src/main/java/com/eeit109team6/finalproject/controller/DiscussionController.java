package com.eeit109team6.finalproject.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.model.SubjectType;
import com.eeit109team6.finalproject.service.IBoardTypeService;
import com.eeit109team6.finalproject.service.IDiscussionService;
import com.eeit109team6.finalproject.service.ISubjectTypeService;

@Controller
public class DiscussionController {

	public DiscussionController() {
	}

	IDiscussionService discussionService;
	IBoardTypeService boardTypeService;
	ISubjectTypeService subjectTypeService;
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

	@Autowired
	public void setSubjectTypeService(ISubjectTypeService subjectTypeService) {
		this.subjectTypeService = subjectTypeService;
	}

	// 討論區主頁:查詢所有看板 --> showDiscussion.jsp
	@RequestMapping("/discussion")
	public String getAllBoardType(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		System.out.println("進入控制器方法getAllBoardType()，即將導向視圖showDiscussion");
		System.out.println("session內的username:" + session.getAttribute("username"));
		// boardTypeService實作方法向DAO取得所有看板的值，將其設給BoardType型態的物件組成的串列
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
	public String getArticleByBoardTypeId(@RequestParam("id") Integer boardId, Model model) {
		List<Discussion> Discussionlist = discussionService.getArticleByBoardTypeId(boardId);// 透過service.getArticleByBoardTypeId方法取得所有指定看板上的文章
		BoardType boardType = boardTypeService.getBoardTypeById(boardId);// 透過service.getBoardTypeById方法取得一個指定看版的看板名稱

		model.addAttribute("DiscussionList", Discussionlist);// 將指定看板上的所有文章物件，都注入model中，識別字串為DiscussionList
		model.addAttribute("boardType", boardType); // 將指定看板的名稱物件，注入model中，識別字串為boardType

		// discussionList 假若不給定名字，僅僅傳入list，則接收方JSP則以物件首字小寫+型態首字大寫List接收。
		// 將service實作類別取得的物件，設給Spring提供的Model介面的model物件
		// Spring提供的注入集合功能，支援List、Map、Properties、Set四種集合。ref:王本p48

		return "board";
	}

	// 查詢單一文章 --> article.jsp
	@RequestMapping("/article")
	public String getArticleById(Model model, @RequestParam("id") Integer articleId) {
		System.out.println("articleId:" + articleId);

		Discussion discussion = discussionService.getArticleById(articleId);

		discussionService.updateViews(articleId);
		Discussion discussion_sessDiscussion = discussionService.getArticleById(articleId);
		model.addAttribute("discussion", discussion_sessDiscussion);

		return "article";
	}

//	提供新增文章時的表單 --> addArticle.jsp 
	@RequestMapping(value = "/addA", method = RequestMethod.GET)
	public String getAddArticleForm(@RequestParam("id") Integer boardId, @RequestParam("name") String name, Model model,
			HttpServletRequest request) {
		System.out.println("****************************************進入Discussion Controller getAddArticleForm()");

		System.out.println("取得request.getSession()");

		List<SubjectType> subjectType = subjectTypeService.getAllSubjectType();// 透過service.getAllSubjectType方法取得所有發文分類
		System.out.println("subjectTypeService.getAllSubjectType()");
//		
		model.addAttribute("subjectType", subjectType); // 將分類名稱物件集合，注入model中，識別字串為subjectType

		model.addAttribute("boardId", boardId);
		model.addAttribute("boardName", name);

		// subjectTypeService實作方法向DAO取得所有發文分類的值，將其設給SubjectType型態的物件組成的串列
		List<BoardType> list = boardTypeService.getAllBoardType();
		System.out.println("在getAddArticleForm()內，抓取看板列表");
		model.addAttribute(list);
		System.out.println("model.addAttribute(list)" + list);

		return "addArticle";
	}

	// 新增文章 -->重定向至所屬的討論看板 board.jsp
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String processAddArticle(@RequestParam("boardId") Integer boardId, @RequestParam("subject") String subject,
			@RequestParam("subjectTypeId") Integer subjectType, @RequestParam("body") String body,
			@RequestParam("author") String author, Model model, HttpServletRequest request) {
		System.out.println("進入processAddArticle()方法");
		BoardType type = boardTypeService.getBoardTypeById(boardId);


		SubjectType Stype = subjectTypeService.getSubjectTypeById(subjectType);
		
		System.out.println("subjectType=" + subjectType);

		// ==============設定發表文章時間=======================
		Calendar rightNow = Calendar.getInstance();
		String createtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定創建帳號時間=======================

		Discussion discussion = new Discussion();
		discussion.setArticleBody(body); // 填入文章
		discussion.setAuthor(author); // 填入作者
		discussion.setSubject(subject); // 填入標題
		discussion.setSubjectType(Stype);// 填入發文分類
		discussion.setBoardType(type); // 填入看版
		discussion.setViews(0); // 填入人氣(計數器)
		discussion.setPostTimeStamp(createtime);// 填入時間戳

		System.out.println("boardId=" + boardId);
		System.out.println("subject=" + subject);
		System.out.println("body=" + body);
		discussionService.addArticle(discussion);
		return "redirect:/board?id=" + boardId; // 重定向至看板，留意key值的用法
	}
}
