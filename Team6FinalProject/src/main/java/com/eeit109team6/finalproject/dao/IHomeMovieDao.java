package com.eeit109team6.finalproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.eeit109team6.finalproject.model.HomeMovie;
import com.eeit109team6.finalproject.model.Movie;
import com.eeit109team6.finalproject.model.MovieInfo;

public interface IHomeMovieDao {

	void setSession(SessionFactory factory);
	
//	=============================================== HomeMovie =======================================================
	HomeMovie findByid(Integer id); // 找單筆 by PK(id)
	void updateMovieid(HomeMovie homeMovie); //更新版塊影片

//	=============================================== Movie =======================================================
	Integer addMovie(Movie movie); //新增影片
	void deleteMovieInfoById(int id); //刪除影片
	void updateMovieInfoById(Movie movie); //更新影片
	List<Movie> findAll();//查詢全部影片
	Movie getMovieInfoByMovieID(Integer id); //查詢指定影片ID資訊
	
	
}