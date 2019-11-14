package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;

public interface INewsService {
//====================================================消息類別=================================================
	void addNewsType(NewsType newsType);
	NewsType getNewsTypeById(Integer newsTypeId);
	List<NewsType> getAllNewsTypes();
	void updateNewsTypeById(NewsType newsType); 
	void deleteNewsTypeById(Integer newsTypeId); 
//====================================================消息====================================================
	void addNews(News news); 
	void addArticlePicture(ArticlePicture articlePicture); 
	List<News> getAllNews();
	void deleteNewsShow(int newsId); //隱藏消息
	void reopenNews(int newsId); //發佈消息
//====================================================未完成===================================================	
	void updateNewsById(News news);
}
