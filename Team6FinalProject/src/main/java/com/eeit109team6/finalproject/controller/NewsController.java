package com.eeit109team6.finalproject.controller;

import java.sql.Blob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.IActivityService;
import com.eeit109team6.finalproject.service.IGameService;
import com.eeit109team6.finalproject.service.INewsService;
import com.eeit109team6.finalproject.service.impl.NewsServiceImpl;

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
	public void setNewsService(INewsService newsService) {
		this.newsService = newsService;
	}

	@Autowired
	public void setGameService(IGameService gameService) {
		this.gameService = gameService;
	}

	@Autowired
	public void setActivityService(IActivityService activityService) {
		this.activityService = activityService;
	}

//====================================================消息類別=================================================

	// 新增消息類別
	@RequestMapping("/newsBack/addNewsType")
	public String addNewsType(@RequestParam("newsTypeName") String newsTypeName) {
		NewsType nt = new NewsType();
		nt.setNewsTypeName(newsTypeName);
		newsService.addNewsType(nt);
		// return "redirect:/newsBack";
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

	// 取得所有消息類別的json格式
	@RequestMapping(value = "/newsBack/searchNewsTypeByAjax", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<NewsType> searchNewsTypeByAjax() {
		return newsService.getAllNewsTypes();
	}

//====================================================消息====================================================

	// 導向新增消息頁面--> addNews.jsp
	@RequestMapping(value = "/newsBack/addNews", method = RequestMethod.GET)
	public String getAddNewNewsForm() {
		return "addNews";
	}

	// 新增消息資料--> 導向上傳圖片頁面 addArticlePicture.jsp
	@RequestMapping(value = "/newsBack/addNews1", method = RequestMethod.POST)
	public String processAddNewNewsForm(HttpServletRequest request, HttpSession session) throws ParseException {
		News news = new News();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date publicationDate = format.parse(format.format(new Date()));// 取得發文時間

		news.setMember((Member) session.getAttribute("mem"));
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

	// 發佈消息隱藏--> 消息後台 newsBack.jsp
	@RequestMapping("/deleteNewsShow")
	public String deleteNewsShow(@RequestParam("newsId") Integer newsId, Model model) {
		newsService.deleteNewsShow(newsId);
		List<News> news = newsService.getAllNews();
		model.addAttribute("news", news);
		return "redirect:/newsBack";
	}

	// 隱藏消息發佈--> 消息後台 newsBack.jsp
	@RequestMapping("/reopenNews")
	public String reopenNews(@RequestParam("newsId") Integer newsId, Model model) {
		newsService.reopenNews(newsId);
		List<News> news = newsService.getAllNews();
		model.addAttribute("news", news);
		return "redirect:/newsBack";
	}

//========================================未完成========================================

	// 查詢所有後臺消息類別--> 消息後台 newsBack.jsp
	@RequestMapping("/newsBack")
	public String newsListBack(Model model) throws ParseException {
		List<NewsType> newsTypeList = newsService.getAllNewsTypes();
		model.addAttribute("newsTypeList", newsTypeList);

		List<GameType> gameTypeList = gameService.getAllGameTypes();
		model.addAttribute("gameTypeList", gameTypeList);

		List<ActivityType> activityTypeList = activityService.getAllActivityTypes();
		model.addAttribute("activityTypeList", activityTypeList);

		List<Game> gameList = gameService.getAllGames();
		model.addAttribute("gameList", gameList);

		List<Activity> activityOneList = activityService.getAllActivities();
		for (Activity a : activityOneList) {
			if (a.getStartingTime_date().equals("00:00:00")) {
				a.setStartingTime_date("");
			}
		}
		// for迴圈要remove List裡的項目要用倒敘刪除，不然會跳過某些值
		for (int i = activityOneList.size() - 1; i >= 0; i--) {
			if (!((activityOneList.get(i)).getStartingDate().equals(""))
					&& !((activityOneList.get(i)).getEndingDate().equals(""))) {
				activityOneList.remove(i);
			}
		}
		model.addAttribute("activityOneList", activityOneList);

		List<Activity> activityMoreList = activityService.getAllActivities();
		for (int i = activityMoreList.size() - 1; i >= 0; i--) {
			if ((!(activityMoreList.get(i)).getStartingDate_time().equals(""))
					&& (!(activityMoreList.get(i)).getStartingTime_date().equals("00:00:00"))) {
				activityMoreList.remove(i);
			}
		}
		model.addAttribute("activityMoreList", activityMoreList);

		List<News> newsShowList = newsService.getAllNews();
		for (int i = newsShowList.size() - 1; i >= 0; i--) {
//			newsShowList.get(i).getPublicationDate();//2019-11-14 20:00:49.0
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String datetime =format.format(newsShowList.get(i).getPublicationDate());//2019-11-14 20:00:49
//			format.parse(datetime);//Thu Nov 14 20:00:49 GMT+08:00 2019	

			if (newsShowList.get(i).getIsVisable() == false) {
				newsShowList.remove(i);
			}
		}
		model.addAttribute("newsShowList", newsShowList);

		List<News> newsHideList = newsService.getAllNews();
		for (int i = newsHideList.size() - 1; i >= 0; i--) {
			if (newsHideList.get(i).getIsVisable() == true) {
				newsHideList.remove(i);
			}
		}
		model.addAttribute("newsHideList", newsHideList);

		return "newsBack";
	}

}
