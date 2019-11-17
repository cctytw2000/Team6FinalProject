package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.dao.IMovieDao;



@Repository
public class MovieDaoImpl implements IMovieDao{
	
	
	SessionFactory factory; 
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
						//	DONE
	@Override
	public void addMovie(MovieInfo movieInfo) {
		Session session = factory.getCurrentSession();
		session.save(movieInfo);
		
	}
						//	DONE
	@Override
	public void deleteMovieInfoById(int movie_ID) {
		Session session = factory.getCurrentSession();
		MovieInfo movieinfo = session.get(MovieInfo.class, movie_ID);
		session.delete(movieinfo);
	}
						//	DONE
	@Override
	public void updateMovieInfoById(MovieInfo movieInfo) {
		Session session = factory.getCurrentSession();
		session.update(movieInfo);	
//		factory.getCurrentSession().update(movieInfo);
//		session.clear();
//		session.update(movieInfo);	
	}
	
//	@Override
//	public void updateViews(Integer boardId) {
//
//		Discussion discussion = factory.getCurrentSession().get(Discussion.class, boardId);
//		discussion.setViews(discussion.getViews() + 1);
//		factory.getCurrentSession().update(discussion);
//	}
	
	@Override
	public MovieInfo getMovieInfoByMovieID(Integer movie_ID) {
		Session session = factory.getCurrentSession();
		MovieInfo movieInfo = session.get(MovieInfo.class, movie_ID);
//		session.save(movieInfo);
		return (MovieInfo) movieInfo;
	}
						//	DONE
	@Override
	public List<MovieInfo> getMovies() {
		String hql = "FROM MovieInfo";  
		List<MovieInfo> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;

	}
                        //	DONE
	@Override
	public List<MovieInfo> getMovieInfoByOwnerID() {
		String hql = "FROM MovieInfo WHERE owner_ID = 9";  
		List<MovieInfo> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}


	

}
