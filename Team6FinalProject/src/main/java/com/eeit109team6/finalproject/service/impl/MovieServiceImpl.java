package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eeit109team6.finalproject.model.MovieInfo;
import com.eeit109team6.finalproject.dao.IMovieDao;
import com.eeit109team6.finalproject.service.IMovieService;

@Service
public class MovieServiceImpl implements IMovieService{

	IMovieDao dao;
	
	@Autowired
	public void setDao(IMovieDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	@Override
	public void addMovie(MovieInfo movieinfo) {
		dao.addMovie(movieinfo);
		
	}
	@Transactional
	@Override
	public void deleteMovieInfoById(int movie_ID) {
		dao.deleteMovieInfoById(movie_ID);
		
	}
	@Transactional
	@Override
	public void updateMovieInfoById(MovieInfo movieinfo) {
		dao.updateMovieInfoById(movieinfo);
		
	}
	@Transactional
	@Override
	public List<MovieInfo> getMovieInfoByOwnerID() {
		return dao.getMovieInfoByOwnerID();
	}
	
	

}
