package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.MovieInfo;

public interface IMovieService {
	
	void addMovie(MovieInfo movieinfo); //新增影片
	void deleteMovieInfoById(int movie_ID); //刪除影片
	void updateMovieInfoById(MovieInfo movieinfo); //更新影片
	void getMovieInfoByMovieID(int movie_ID); //搜尋單一影片ID的資訊
	
	List<MovieInfo> getMovieInfoByOwnerID(); //尋找使用者Owner_ID上傳的影片
	List<MovieInfo> getMovies();
	
}
