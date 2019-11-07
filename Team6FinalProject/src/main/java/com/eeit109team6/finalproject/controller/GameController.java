package com.eeit109team6.finalproject.controller;

import java.util.Calendar;
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
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.IGameService;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class GameController {

	public GameController() {
	}

	IGameService gameService;
	INewsService newsService;

	@Autowired
	public void setService(IGameService gameService) {
		this.gameService = gameService;
	}

	@Autowired
	public void setService(INewsService newsService) {
		this.newsService = newsService;
	}

	// 導向新增遊戲頁面--> addGame.jsp
	@RequestMapping(value = "/newsBack/addGame", method = RequestMethod.GET)
	public String getAddNewGameForm(Model model) {
		Game game = new Game();
		game.setGameName("lineage");
		model.addAttribute("game", game);

		List<GameType> list = gameService.getAllGameTypes();
		Map<Integer, String> gameTypeMap = new HashMap<>();
		for (GameType g : list) {
			gameTypeMap.put(g.getGameTypeId(), g.getGameTypeName());
		}
		model.addAttribute("gameTypeMap", gameTypeMap);

		return "addGame";
	}

	// 新增遊戲--> 新聞後台 newsBack.jsp
	@RequestMapping(value = "/newsBack/add", method = RequestMethod.POST)
	public String processAddNewGameForm(@ModelAttribute("game") Game game) {
		System.out.println("getGameType_" + game.getGameType_());
		System.out.println("getNewsType_" + game.getNewsType_());
		System.out.println("getGameType_" + game.getGameName());
		Integer gt_ = game.getGameType_(); // 取回遊戲類別分類id
		GameType gt = gameService.getGameTypeById(gt_); // 利用id取得遊戲類別
		System.out.println("geme type name == " + gt.getGameTypeName());
		Integer nt_ = game.getNewsType_(); // 取回新聞類別分類id
		NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別

		System.out.println("news type name " + nt.getNewsTypeName());

		System.out.println("time  " + game.getPublicationDate());
		// ==============設定創建帳號時間=======================
		Calendar rightNow = Calendar.getInstance();
		String registeredtime = rightNow.get(Calendar.YEAR) + "-" + (rightNow.get(Calendar.MONTH) + 1) + "-"
				+ rightNow.get(Calendar.DATE) + " " + rightNow.get(Calendar.HOUR) + ":" + rightNow.get(Calendar.MINUTE)
				+ ":" + rightNow.get(Calendar.SECOND);
		// ==============/設定創建帳號時間=======================
		
		
		
		
		
		game.setGameType(gt); // 設定遊戲的遊戲類別
		game.setNewsType(nt); // 設定遊戲的新聞類別

		gameService.addGame(game);
		return "redirect:/newsBack";
	}

	// 新增遊戲類別
	@RequestMapping("/newsBack/addGameType")
	public String addGameType(@RequestParam("gameTypeName") String gameTypeName) {
		GameType gt = new GameType();
		gt.setGameTypeName(gameTypeName);
		gameService.addGameType(gt);
		return "redirect:/newsBack";
	}

	// 查詢所有遊戲類別並存入Model
	@ModelAttribute("gameTypes")
	public List<GameType> getGameTypes() {
		return gameService.getAllGameTypes();
	}

	// 導向新聞後台 --> newsBack.jsp
	@RequestMapping("/addGame/cancel")
	public String goBackToNewsBack(Model model) {
		return "newsBack";
	}

	// 新增遊戲--> 商城後台 addGamesBack.jsp
//	@RequestMapping(value = "/games/add", method = RequestMethod.POST)
//	public String processAddNewGameForm(@ModelAttribute("game") Game game) {
//		service.addGame(game);
//		return "redirect:/gamesBack";
//	}

}
