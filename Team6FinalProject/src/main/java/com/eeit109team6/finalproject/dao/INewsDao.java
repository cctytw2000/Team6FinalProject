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
//====================================================未完成===================================================		
	List<News> getAllNews(); //查詢所有消息
	
	void deleteNewsById(int newsId); //刪除消息
	void updateNewsById(int newsId); //更新消息
}
