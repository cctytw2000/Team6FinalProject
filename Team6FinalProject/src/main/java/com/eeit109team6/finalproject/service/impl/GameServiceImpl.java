package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IGameDAO;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.service.IGameService;

@Service
public class GameServiceImpl implements IGameService {

	public GameServiceImpl() {
	}
	
	IGameDAO dao;
	
	@Autowired
	public void setDao(IGameDAO dao) {
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
	
//====================================================未完成====================================================
	@Transactional
	@Override
	public List<Game> getAllGame() {
		return dao.getAllGame();
	}

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

	@Transactional
	@Override
	public Game getGameById(int gameId) {
		return dao.getGameById(gameId);
	}

	
	
}
