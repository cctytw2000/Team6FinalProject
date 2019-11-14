package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.INewsDao;
import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService{

	public NewsServiceImpl(){
	}
	
	INewsDao dao;
	@Autowired
	public void setDao(INewsDao dao) {
		this.dao = dao;
	}

//====================================================消息類別=================================================

	@Transactional
	@Override
	public void addNewsType(NewsType newsType) {
		dao.addNewsType(newsType);		
	}
	
	@Transactional
	@Override
	public NewsType getNewsTypeById(Integer newsTypeId) {
		return dao.getNewsTypeById(newsTypeId);
	}
	
	@Transactional
	@Override
	public List<NewsType> getAllNewsTypes() {
		return dao.getAllNewsTypes();
	}
	
	@Transactional
	@Override
	public void updateNewsTypeById(NewsType newsType) {
		dao.updateNewsTypeById(newsType);
	}
	
	@Transactional
	@Override
	public void deleteNewsTypeById(Integer newsTypeId) {
		dao.deleteNewsTypeById(newsTypeId);
	}

//====================================================消息====================================================
	
	@Transactional
	@Override
	public void addNews(News news) {
		dao.addNews(news);	
	}
	
	@Transactional
	@Override
	public void addArticlePicture(ArticlePicture articlePicture) {
		dao.addArticlePicture(articlePicture);		
	}

//====================================================未完成====================================================
	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deleteNewsById(int newsId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNewsById(News news) {
		// TODO Auto-generated method stub
		
	}

	
	

	

	

}
