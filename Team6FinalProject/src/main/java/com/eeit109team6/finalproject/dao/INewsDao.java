package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.model.Product;

public interface INewsDao {
//====================================================消息類別=================================================
	void addNewsType(NewsType newsType);//新增消息類別
	NewsType getNewsTypeById(Integer newsTypeId);//取得newsTypeId
	List<NewsType> getAllNewsTypes();
	void updateNewsTypeById(NewsType newsType); //更新消息類別
	void deleteNewsTypeById(Integer newsTypeId); //刪除消息類別
//====================================================消息====================================================
	void addNews(News news); //新增消息
	void addArticlePicture(ArticlePicture articlePicture); 
	List<News> getAllNews(); //查詢所有消息
	void deleteNewsShow(int newsId); //隱藏消息
	void reopenNews(int newsId); //發佈消息
//====================================================未完成===================================================		
	
	void updateNewsById(int newsId); //更新消息
}
