package com.eeit109team6.finalproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class NewsController {

	public NewsController() {
	}

	INewsService newsService;

	@Autowired
	public void setService(INewsService newsService) {
		this.newsService = newsService;
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
				News news= new News();
				model.addAttribute("news", news);

				List<NewsType> list = newsService.getAllNewsTypes();
				Map<Integer, String> newsTypeMap = new HashMap<>();
				for (NewsType n : list) {
					newsTypeMap.put(n.getNewsTypeId(), n.getNewsTypeName());
				}
				model.addAttribute("newsTypeMap", newsTypeMap);

				return "addNews";
			}
//========================================未完成========================================
			// 新增遊戲--> 消息後台 newsBack.jsp
			@RequestMapping(value = "/newsBack/addNews1", method = RequestMethod.POST)
			public String processAddNewNewsForm(@ModelAttribute("news") News news) {
				Integer nt_ = news.getNewsType_(); // 取回新聞類別分類id
				NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別
				// ==============其實不用=======================
				// ==============設定發行日期(時間)=======================
//				Calendar rightNow = Calendar.getInstance();
//				String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
//						+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
//						+ ":" + rightNow.get(Calendar.SECOND);
				// ==============/設定發行日期(時間)=======================
				news.setNewsType(nt); // 設定遊戲的新聞類別
				newsService.addNews(news);
				return "redirect:/newsBack";
			}

}
