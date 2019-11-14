package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.INewsDao;
import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ArticlePicture;
import com.eeit109team6.finalproject.model.GameType;
import com.eeit109team6.finalproject.model.News;
import com.eeit109team6.finalproject.model.NewsType;
import com.eeit109team6.finalproject.model.Product;

@Repository
public class NewsDaoImpl implements INewsDao {

	public NewsDaoImpl() {
	}

	SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//====================================================消息類別=================================================

	@Override
	public void addNewsType(NewsType newsType) {
		Session session = sessionFactory.getCurrentSession();
		session.save(newsType);
	}

	@Override
	public NewsType getNewsTypeById(Integer newsTypeId) {
		Session session = sessionFactory.getCurrentSession();
		NewsType newsType = session.get(NewsType.class, newsTypeId);
		return newsType;
	}

	@Override
	public List<NewsType> getAllNewsTypes() {
		String hql = "From NewsType";
		Session session = sessionFactory.getCurrentSession();
		List<NewsType> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void updateNewsTypeById(NewsType newsType) {
		Session session = sessionFactory.getCurrentSession();
		session.clear();
		session.update(newsType);
	}

	@Override
	public void deleteNewsTypeById(Integer newsTypeId) {
		Session session = sessionFactory.getCurrentSession();
		NewsType nt = session.get(NewsType.class, newsTypeId);
		session.delete(nt);
	}

//====================================================消息====================================================

	@Override
	public void addNews(News news) {
		Session session = sessionFactory.getCurrentSession();
		session.save(news);
	}

	@Override
	public void addArticlePicture(ArticlePicture articlePicture) {
		Session session = sessionFactory.getCurrentSession();
		session.save(articlePicture);
	}
	
	@Override
	public List<News> getAllNews() {
		String hql = "FROM News";
		List<News> list = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void deleteNewsShow(int newsId) {
		Session session = sessionFactory.getCurrentSession();
		News news = session.get(News.class, newsId);
		news.setIsVisable(false);
		session.update(news);
	}
	
	@Override
	public void reopenNews(int newsId) {
		Session session = sessionFactory.getCurrentSession();
		News news = session.get(News.class, newsId);
		news.setIsVisable(true);
		session.update(news);		
	}
//====================================================未完成===================================================	
	
	@Override
	public void updateNewsById(int newsId) {
		// TODO Auto-generated method stub

	}

	

}
