package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IGameDao;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.Product;

@Repository
public class GameDaoImpl implements IGameDao {

	public GameDaoImpl() {
	}

	SessionFactory factory;

	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addGameType(GameType gametype) {
		Session session = factory.getCurrentSession();
		session.save(gametype);
	}

	@Override
	public List<GameType> getAllGameTypes() {
		String hql = "FROM GameType";
		Session session = factory.getCurrentSession();
		List<GameType> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public GameType getGameTypeById(Integer gameTypeId) {
		Session session = factory.getCurrentSession();
		GameType gameType = session.get(GameType.class, gameTypeId);
		return gameType;
	}
	
	@Override
	public List<Game> getAllGames() {
		String hql = "FROM Game";
		List<Game> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	

	@Override
	public Game getGameById(Integer gameId) {
		Session session = factory.getCurrentSession();
		Game game = session.get(Game.class, gameId);
		return game;
	}
	
	@Override
	public void addGame(Game game) {
		Session session = factory.getCurrentSession();
		session.save(game);
	}
//====================================================未完成====================================================

	

	@Override
	public void deleteGameById(Integer gameId) {
		Session session = factory.getCurrentSession();
		Game game = session.get(Game.class, gameId);
		session.delete(game);

	}

	@Override
	public void updateGameById(Game game) {
		Session session = factory.getCurrentSession();
		session.update(game);
	}


}
