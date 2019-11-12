package com.eeit109team6.finalproject.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.IGameService;
import com.eeit109team6.finalproject.service.INewsService;

@Controller
public class GameController {

	public GameController() {
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
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
		model.addAttribute("game", game);

		List<GameType> list = gameService.getAllGameTypes();
		Map<Integer, String> gameTypeMap = new HashMap<>();
		for (GameType g : list) {
			gameTypeMap.put(g.getGameTypeId(), g.getGameTypeName());
		}
		model.addAttribute("gameTypeMap", gameTypeMap);

		return "addGame";
	}

	// 新增遊戲--> 消息後台 newsBack.jsp
	@RequestMapping(value = "/newsBack/addGame1", method = RequestMethod.POST)
	public String processAddNewGameForm(@ModelAttribute("game") Game game) throws ParseException {
		Integer gt_ = game.getGameType_(); // 取回遊戲類別分類id
		GameType gt = gameService.getGameTypeById(gt_); // 利用id取得遊戲類別
		Integer nt_ = game.getNewsType_(); // 取回新聞類別分類id
		NewsType nt = newsService.getNewsTypeById(nt_); // 利用id取得新聞類別
		//改變日期格式
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String PublicationDate = format1.format((Date)format.parse(game.getPublicationDate()));
		game.setPublicationDate(PublicationDate);
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

	// 用ajax傳回gameDetail給addNews.jsp
	@RequestMapping(value = "/newsBack/searchGameByAjax", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> test(@RequestParam("gameId") Integer gameId) {
//		System.out.println(gameId);
		Game g = gameService.getGameById(gameId);
		Map<String, String> gameMap = new HashMap<>();
		gameMap.put("name", g.getGameName());
		// 若未設定發售日則傳回未設定 
		if (g.getPublicationDate().equals("")) {
			gameMap.put("publicationDate", "未設定");
		} else {
			gameMap.put("publicationDate", g.getPublicationDate());
		}
		gameMap.put("publisher", g.getPublisher());
		gameMap.put("platform", g.getPlatform());

		return gameMap;
	}
	
	// 更新遊戲類別名稱-->newsBack.jsp
		@RequestMapping(value = "/updateGameType", method = RequestMethod.POST)
		public String updateGameTypeById(@RequestParam("gameTypeId") Integer gameTypeId,@RequestParam("gmaeTypeName") String gameTypeName) {
			GameType gt = gameService.getGameTypeById(gameTypeId);
			gt.setGameTypeName(gameTypeName);
			gameService.updateGameTypeById(gt);

			return "redirect:/newsBack";
		}

		// 刪除遊戲類別-->newsBack.jsp
		@RequestMapping(value = "/deleteGameType", method = RequestMethod.POST)
		public String deleteGameTypeById(@RequestParam("gameTypeId") Integer gameTypeId) {
			gameService.deleteGameTypeById(gameTypeId);
			return "redirect:/newsBack";
		}

}
