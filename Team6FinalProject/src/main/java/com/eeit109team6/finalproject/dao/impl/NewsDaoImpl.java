package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.INewsDao;
import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.model.Product;

@Repository
public class NewsDaoImpl implements INewsDao {

	public NewsDaoImpl() {
	}
	
	SessionFactory factory;

	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addNewsType(NewsType newsType) {
		Session session = factory.getCurrentSession();
		session.save(newsType);		
	}
	
	@Override
	public NewsType getNewsTypeById(Integer newsTypeId) {
		Session session = factory.getCurrentSession();
		NewsType newsType = session.get(NewsType.class, newsTypeId);
		return newsType;
	}
	
	@Override
	public List<NewsType> getAllNewsTypes() {
		String hql = "From NewsType";
		Session session = factory.getCurrentSession();
		List<NewsType> list = new ArrayList<>();
		list=session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public void addNews(News news) {
		Session session = factory.getCurrentSession();
		session.save(news);
	}
	
	@Override
	public void addArticlePicture(ArticlePicture articlePicture) {
		Session session = factory.getCurrentSession();
		session.save(articlePicture);		
	}
	
	@Override
	public void updateNewsTypeById(NewsType newsType) {
		Session session = factory.getCurrentSession();
		session.clear();
		session.update(newsType);
	}
	
	@Override
	public void deleteNewsTypeById(Integer newsTypeId) {
		Session session = factory.getCurrentSession();
		NewsType nt = session.get(NewsType.class, newsTypeId);
		session.delete(nt);		
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
	public void updateNewsById(int newsId) {
		// TODO Auto-generated method stub

	}

	

	

	

	

}
