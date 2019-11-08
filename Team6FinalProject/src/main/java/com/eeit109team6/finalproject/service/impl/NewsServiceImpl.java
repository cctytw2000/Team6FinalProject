package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.INewsDao;
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
	public void addNews(News news) {
		dao.addNews(news);	
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
