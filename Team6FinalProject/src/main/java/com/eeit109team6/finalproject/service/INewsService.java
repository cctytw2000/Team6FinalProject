package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;

public interface INewsService {
	void addNewsType(NewsType newsType);
	NewsType getNewsTypeById(Integer newsTypeId);
	List<NewsType> getAllNewsTypes();
	void addNews(News news); 
	void addArticlePicture(ArticlePicture articlePicture); 
	void updateNewsTypeById(NewsType newsType); 
	void deleteNewsTypeById(Integer newsTypeId); 
//====================================================未完成====================================================		
	List<News> getAllNews(); 
	
	void deleteNewsById(int newsId); 
	void updateNewsById(News news);
}
