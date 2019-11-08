package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.dao.IMovieDao;



@Repository
public class MovieDaoImpl implements IMovieDao{
	
	
	SessionFactory factory; 
	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void addMovie(MovieInfo movieinfo) {
		Session session = factory.getCurrentSession();
		session.save(movieinfo);
		
	}

	@Override
	public void deleteMovieInfoById(int movie_ID) {
		Session session = factory.getCurrentSession();
		MovieInfo movieinfo = session.get(MovieInfo.class, movie_ID);
		session.delete(movieinfo);
		
	}

	@Override
	public void updateMovieInfoById(MovieInfo movieinfo) {
		Session session = factory.getCurrentSession();
		session.update(movieinfo);	
	}

	
	@Override
	public List<MovieInfo> getMovieInfoByOwnerID() {
		String hql = "FROM MovieInfo WHERE owner_ID = 9";  
		List<MovieInfo> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

}
