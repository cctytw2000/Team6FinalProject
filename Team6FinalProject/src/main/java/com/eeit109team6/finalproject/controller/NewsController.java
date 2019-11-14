package com.eeit109team6.finalproject.controller;

import java.sql.Blob;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;
import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.IActivityService;
import com.eeit109team6.finalproject.service.IGameService;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class NewsController {

	public NewsController() {
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	INewsService newsService;
	IGameService gameService;
	IActivityService activityService;

	@Autowired
	public void setService(INewsService newsService) {
		this.newsService = newsService;
	}

	@Autowired
	public void setService(IGameService gameService) {
		this.gameService = gameService;
	}

	@Autowired
	public void setService(IActivityService activityService) {
		this.activityService = activityService;
	}

	// 新增消息類別
	@RequestMapping("/newsBack/addNewsType")
	public String addNewsType(@RequestParam("newsTypeName") String newsTypeName) {
		NewsType nt = new NewsType();
		nt.setNewsTypeName(newsTypeName);
		newsService.addNewsType(nt);
		// return "redirect:/newsBack";
		return "redirect:/newsBack";
	}

	// 導向新增消息頁面--> addNews.jsp
	@RequestMapping(value = "/newsBack/addNews", method = RequestMethod.GET)
	public String getAddNewNewsForm() {
		return "addNews";
	}

	// 新增消息資料--> 導向上傳圖片頁面 addArticlePicture.jsp
	@RequestMapping(value = "/newsBack/addNews1", method = RequestMethod.POST)
	public String processAddNewNewsForm(HttpServletRequest request, HttpSession session) {
		News news = new News();

		Integer mi = (Integer) session.getAttribute("member_id");// 取得發文者id
		Member member = new Member();
		member.setMember_id(mi);
		Date publicationDate = new Date();// 取得發文時間

		news.setMember(member);
		news.setIpAddress(request.getRemoteAddr());// 取得發文位置
		news.setPublicationDate(publicationDate);
		news.setNewsType(newsService.getNewsTypeById(Integer.parseInt(request.getParameter("newsType"))));
		if (!(request.getParameter("game") == null)) {
			news.setGame(gameService.getGameById(Integer.parseInt(request.getParameter("game"))));
		}
		if (!(request.getParameter("activity") == null)) {
			news.setActivity(activityService.getActivityById(Integer.parseInt(request.getParameter("activity"))));
		}
		news.setTitle(request.getParameter("title"));
		System.out.println(news.getTitle());
		news.setArticle(request.getParameter("article"));
		if (request.getParameter("isVisable") == null) {

		} else if (Integer.parseInt(request.getParameter("isVisable")) == 1) {
			news.setIsVisable(true);
		} else {
			news.setIsVisable(false);
		}

		session.setAttribute("addNews", news);

		return "addArticlePicture";
	}

	// 新增消息圖片--> 導向消息後台newsBack.jsp
	@RequestMapping(value = "/newsBack/addArticlePicture", method = RequestMethod.POST)
	public String getAddNewPicturesForm(@RequestParam("newsImage") MultipartFile newsImage, HttpServletRequest request,
			HttpSession session) {
		News news = (News) session.getAttribute("addNews");
		newsService.addNews(news);
//		System.out.println(news.getTitle());
		ArticlePicture articlePicture = new ArticlePicture();

//		測試上傳圖片
		String originalFilename = newsImage.getOriginalFilename();
		if (newsImage != null && !newsImage.isEmpty()) {
			try {
				byte[] b = newsImage.getBytes();
				Blob blob = new SerialBlob(b);
				articlePicture.setPicture(blob);
				articlePicture.setNews(news);
				newsService.addArticlePicture(articlePicture);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常:" + e.getMessage());
			}
		}
		System.out.println("img=" + articlePicture.getNewsImage());

		session.removeAttribute("addNews");
		return "redirect:/newsBack";
	}

	// 更新消息類別名稱-->newsBack.jsp
	@RequestMapping(value = "/updateNewsType", method = RequestMethod.POST)
	public String updateNewsTypeById(@RequestParam("newsTypeId") Integer newsTypeId,
			@RequestParam("newsTypeName") String newsTypeName) {
		System.out.println("newsTypeName=" + newsTypeName);
		System.out.println("updateNewsType");
		NewsType nt = newsService.getNewsTypeById(newsTypeId);
		nt.setNewsTypeName(newsTypeName);
		newsService.updateNewsTypeById(nt);

		return "redirect:/newsBack";
	}

	// 刪除消息類別-->newsBack.jsp
	@RequestMapping(value = "/deleteNewsType", method = RequestMethod.POST)
	public String deleteNewsTypeById(@RequestParam("newsTypeId") Integer newsTypeId) {
		newsService.deleteNewsTypeById(newsTypeId);
		return "redirect:/newsBack";
	}

	// 取得所有活動類別的json格式
	@RequestMapping(value = "/newsBack/searchNewsTypeByAjax", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<NewsType> searchNewsTypeByAjax() {
		return newsService.getAllNewsTypes();
	}

//========================================未完成========================================

	// 查詢所有後臺消息類別--> 消息後台 newsBack.jsp
	@RequestMapping("/newsBack")
	public String newsListBack(Model model) {
		List<NewsType> newsTypeList = newsService.getAllNewsTypes();
		model.addAttribute("newsTypeList", newsTypeList);

		List<GameType> gameTypeList = gameService.getAllGameTypes();
		model.addAttribute("gameTypeList", gameTypeList);

		List<ActivityType> activityTypeList = activityService.getAllActivityTypes();
		model.addAttribute("activityTypeList", activityTypeList);

		List<Game> gameList = gameService.getAllGames();
		for (Game game : gameList) {
			if (game.getPublicationDate().equals("")) {
				game.setPublicationDate("未設定");
			}
		}
		model.addAttribute("gameList", gameList);

//			List<Category> categories = service.getAllCategories();
//			Map<Integer, String> categoryMap = new HashMap<>();
//			for(Category c : categories) {
//				categoryMap.put(c.getCategory_id(), c.getCategory());
//			}
//			model.addAttribute("categoryMap", categoryMap);

		return "newsBack";
	}

}
