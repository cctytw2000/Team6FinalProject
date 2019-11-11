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
import org.springframework.web.multipart.MultipartFile;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.Game;
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

	// 查詢所有遊戲類別並存入Model
	@ModelAttribute("newsTypes")
	public List<NewsType> getNewsTypes() {
		return newsService.getAllNewsTypes();
	}

	// 導向消息後台 --> newsBack.jsp
	@RequestMapping("/newsBack")
	public String addGame(Model model) {
		return "newsBack";
	}

	// 導向新增遊戲頁面--> addNews.jsp
	@RequestMapping(value = "/newsBack/addNews", method = RequestMethod.GET)
	public String getAddNewNewsForm(Model model, HttpSession session) {

		News news = new News();
		model.addAttribute("news", news);

		List<NewsType> list = newsService.getAllNewsTypes();
		Map<Integer, String> newsTypeMap = new HashMap<>();
		for (NewsType n : list) {
			newsTypeMap.put(n.getNewsTypeId(), n.getNewsTypeName());
		}

		List<Game> list_game = gameService.getAllGames();
		Map<Integer, String> gameMap = new HashMap<>();
		for (Game g : list_game) {
			gameMap.put(g.getGameId(), g.getGameName());
		}

		List<Activity> list_activity = activityService.getAllActivities();
		Map<Integer, String> activityMap = new HashMap<>();
		for (Activity a : list_activity) {
			activityMap.put(a.getActivityId(), a.getActivityName());
		}
		model.addAttribute("gameMap", gameMap);
		model.addAttribute("activityMap", activityMap);
		model.addAttribute("newsTypeMap", newsTypeMap);

		return "addNews";
	}

//========================================未完成========================================
	// 新增遊戲--> 消息後台 newsBack.jsp
	@RequestMapping(value = "/newsBack/addNews1", method = RequestMethod.POST)
	public String processAddNewNewsForm(@ModelAttribute("news") News news, HttpServletRequest request,
			HttpSession session, Model model) {

		Integer mi = (Integer) session.getAttribute("member_id");// 取得發文者id
		Member member = new Member();
		member.setMember_id(mi);
		Date publicationDate = new Date();// 取得發文時間
		Integer nt_ = news.getNewsType_(); // 取回表單新聞類別id
		NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別
		Integer g_ = news.getGame_();// 取回表單遊戲id
		Game g = gameService.getGameById(g_);
		Integer a_ = news.getActivity_();// 取回表單活動id
		Activity a = activityService.getActivityById(a_);

		news.setMember(member);
		news.setIpAddress(request.getRemoteAddr());// 取得發文位置
		news.setPublicationDate(publicationDate);
		news.setNewsType(nt);
		news.setGame(g);
		news.setActivity(a);
		
		ArticlePicture articlePicture = new ArticlePicture();
		articlePicture.setNews(news);

		session.setAttribute("addNews", news);

		model.addAttribute("articlePicture", articlePicture);
		return "addArticlePicture";
	}

	// 導向新增遊戲頁面--> addNews.jsp
	@RequestMapping(value = "/newsBack/addArticlePicture", method = RequestMethod.POST)
	public String getAddNewPicturesForm(@ModelAttribute("articlePicture") ArticlePicture articlePicture,
			HttpSession session) {
		News news = (News) session.getAttribute("addNews");
		articlePicture.setNews(news);
		System.out.println("title=" + articlePicture.getNews().getTitle());
		newsService.addNews(news);
		System.out.println("newsId=" +articlePicture.getNews().getNewsId());
	
//		測試上傳圖片
				MultipartFile newsImage = articlePicture.getNewsImage();
				String originalFilename = newsImage.getOriginalFilename();
				if(newsImage != null && !newsImage.isEmpty()) {
					try {
						byte[] b = newsImage.getBytes();
						Blob blob = new SerialBlob(b);
						articlePicture.setPicture(blob);
						newsService.addArticlePicture(articlePicture);
					} catch(Exception e) {
						e.printStackTrace();
						throw new RuntimeException("檔案上傳發生異常:"+e.getMessage());
					}
				}
		System.out.println("img=" + articlePicture.getNewsImage());
		
		
		session.removeAttribute("addNews");
		return "redirect:/newsBack";
	}

}
