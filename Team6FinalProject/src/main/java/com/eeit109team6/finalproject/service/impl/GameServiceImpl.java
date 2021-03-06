package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IGameDao;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.service.IGameService;

@Service
public class GameServiceImpl implements IGameService {

	public GameServiceImpl() {
	}
	
	IGameDao dao;
	
	@Autowired
	public void setDao(IGameDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void addGameType(GameType gametype) {
		dao.addGameType(gametype);
	}

	@Transactional
	@Override
	public List<GameType> getAllGameTypes() {
		return dao.getAllGameTypes();
	}
	
	@Transactional
	@Override
	public GameType getGameTypeById(Integer gameTypeId) {
		return dao.getGameTypeById(gameTypeId);
	}
	
	@Transactional
	@Override
	public List<Game> getAllGames() {
		return dao.getAllGames();
	}
	
	@Transactional
	@Override
	public Game getGameById(Integer gameId) {
		return dao.getGameById(gameId);
	}
	
//====================================================未完成====================================================
	

	@Transactional
	@Override
	public void addGame(Game game) {
		dao.addGame(game);		
	}

	@Transactional
	@Override
	public void deleteGameById(int gameId) {
		dao.deleteGameById(gameId);	
	}

	@Transactional
	@Override
	public void updateGameById(Game game) {
		dao.updateGameById(game);
		
	}

	

	
	
}
