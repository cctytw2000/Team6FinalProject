package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;

public interface INewsDao {
	void addNewsType(NewsType newsType);//新增新聞類別
	NewsType getNewsTypeById(Integer newsTypeId);//取得newsTypeId
	List<NewsType> getAllNewsTypes();
	void addNews(News news); //新增新聞
	void addArticlePicture(ArticlePicture articlePicture); 
//====================================================未完成====================================================		
	List<News> getAllNews(); //查詢所有新聞
	
	void deleteNewsById(int newsId); //刪除新聞
	void updateNewsById(int newsId); //更新新聞
}
