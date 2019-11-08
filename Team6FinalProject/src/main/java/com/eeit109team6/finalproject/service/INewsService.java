package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;

public interface INewsService {
	void addNewsType(NewsType newsType);
	NewsType getNewsTypeById(Integer newsTypeId);
	List<NewsType> getAllNewsTypes();
//====================================================未完成====================================================		
	List<News> getAllNews(); 
	void addNews(News news); 
	void deleteNewsById(int newsId); 
	void updateNewsById(News news);
}
