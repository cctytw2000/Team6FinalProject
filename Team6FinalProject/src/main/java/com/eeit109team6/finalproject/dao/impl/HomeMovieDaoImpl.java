package com.eeit109team6.finalproject.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IHomeMovieDao;
import com.eeit109team6.finalproject.model.HomeMovie;

@Repository
public class HomeMovieDaoImpl implements IHomeMovieDao {

	public HomeMovieDaoImpl() {
	}

	SessionFactory factory;

	@Override
	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public HomeMovie findByid(Integer id) {
		HomeMovie homeMov = factory.getCurrentSession().get(HomeMovie.class, id);

		return homeMov;
	}

}
