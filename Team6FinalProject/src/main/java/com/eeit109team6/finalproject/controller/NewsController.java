package com.eeit109team6.finalproject.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.IActivityService;
import com.eeit109team6.finalproject.service.IGameService;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.INewsService;
import com.google.protobuf.Timestamp;

@Controller
public class NewsController {

	public NewsController() {
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
	public String getAddNewNewsForm(Model model) {
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
			HttpSession session) {
		Integer mi = (Integer) session.getAttribute("member_id");
		Member member = new Member();
		member.setMember_id(mi);
		Date publicationDate = new Date();
		Integer nt_ = news.getNewsType_(); // 取回新聞類別分類id
		NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別
		Integer g_ = news.getGame_();
		Game g = gameService.getGameById(g_);
		Integer a_ = news.getActivity_();
		Activity a = activityService.getActivityById(a_);
		// ==============其實不用=======================
		// ==============設定發行日期(時間)=======================
//				Calendar rightNow = Calendar.getInstance();
//				String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
//						+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
//						+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定發行日期(時間)=======================
		news.setMember(member);
		news.setIpAddress(request.getRemoteAddr());
		news.setPublicationDate(publicationDate);
		news.setNewsType(nt); // 設定遊戲的新聞類別
		news.setGame(g);
		news.setActivity(a);
		newsService.addNews(news);
		return "redirect:/newsBack";
	}

}
