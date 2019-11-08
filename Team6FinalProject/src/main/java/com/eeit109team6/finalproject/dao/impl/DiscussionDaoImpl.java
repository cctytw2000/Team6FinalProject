package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IDiscussionDAO;
import com.eeit109team6.finalproject.model.Discussion;

@Repository
public class DiscussionDaoImpl implements IDiscussionDAO {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Discussion> getAllArticles() {
		
		String hql = "FROM Discussion";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	

	@Override
	public Discussion getArticleById(int articleId) {
		Session session = factory.getCurrentSession();
		Discussion discussion = session.get(Discussion.class, articleId);
		return discussion;
	}

	@Override
	public void addArticle(Discussion discussion) {
		Session session = factory.getCurrentSession();
		session.save(discussion);
	}

}
