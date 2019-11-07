package com.eeit109team6.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class NewsController {

	public NewsController() {
	}

	INewsService service;

	@Autowired
	public void setService(INewsService service) {
		this.service = service;
	}

	// 新增新聞類別
	@RequestMapping("/newsBack/addNewsType")
	public String addNewsType(@RequestParam("newsTypeName") String newsTypeName) {
		NewsType nt = new NewsType();
		nt.setNewsTypeName(newsTypeName);
		service.addNewsType(nt);
		return "redirect:/newsBack";
	}

	// 導向新聞後台 --> newsBack.jsp
	@RequestMapping("/newsBack")
	public String addGame(Model model) {
		return "newsBack";
	}

//	// 導向新增遊戲頁面--> addGame.jsp
//	@RequestMapping(value = "/newsBack/addGame", method = RequestMethod.GET)
//	public String getAddNewGameForm(Model model) {
//		Game game = new Game();
//		model.addAttribute("game", game);
//		return "addGame";
//	}

	// 新增遊戲--> 商城後台 addGamesBack.jsp
//	@RequestMapping(value = "/games/add", method = RequestMethod.POST)
//	public String processAddNewGameForm(@ModelAttribute("game") Game game) {
//		service.addGame(game);
//		return "redirect:/gamesBack";
//	}

}
