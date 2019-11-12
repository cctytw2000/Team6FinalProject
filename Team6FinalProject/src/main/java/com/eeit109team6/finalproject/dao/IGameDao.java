package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.NewsType;

public interface IGameDao {
	void addGame(Game game);
	void addGameType(GameType gameType);
	List<GameType> getAllGameTypes();
	GameType getGameTypeById(Integer gameTypeId); 
	List<Game> getAllGames(); 
	Game getGameById(Integer gameId);
	void updateGameTypeById(GameType gameType); //更新遊戲類別
	void deleteGameTypeById(Integer gameTypeId); //刪除遊戲類別
//====================================================未完成====================================================		
	
	void deleteGameById(Integer gameId); 
	void updateGameById(Game game); 
	
}
