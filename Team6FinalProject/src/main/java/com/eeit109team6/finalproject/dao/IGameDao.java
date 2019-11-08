package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;

public interface IGameDao {
	void addGame(Game game);
	void addGameType(GameType gameType);
	List<GameType> getAllGameTypes();
	GameType getGameTypeById(Integer gameTypeId); 
//====================================================未完成====================================================		
	List<Game> getAllGame(); 
	void deleteGameById(int gameId); 
	void updateGameById(Game game); 
	public Game getGameById(int gameId);
}
