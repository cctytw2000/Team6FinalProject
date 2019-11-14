package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IDiscussionDao;
import com.eeit109team6.finalproject.model.Discussion;

@Repository
public class DiscussionDaoImpl implements IDiscussionDao {

	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discussion> getAllArticles() {
		
		String hql = "FROM Discussion";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Discussion> getArticleByBoardTypeId(Integer boardId) {
		
		String hql = "FROM Discussion WHERE boardId = :boardId";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("boardId", boardId).getResultList();
		
		return list;
	}
	

	@Override
	public Discussion getArticleById(int articleId) {
		
//		String hql = "UPDATE Discussion SET views = views + :seqIncrement WHERE articleId = :articleId returning views";
//		String hql = "UPDATE Discussion d SET d.views = d.views + 1 WHERE articleId = :articleId";
		
//		String sql = "UPDATE Discussion SET views = views + :seqIncrement WHERE articleId = articleId";
		Session session = factory.getCurrentSession();
//		NativeQuery query = session.createNativeQuery(sql, Discussion.class);
		
//		String hql = "UPDATE Discussion SET views = views + 1 WHERE articleId = :articleId";
//		String hql = "UPDATE Discussion SET views = views + 1 WHERE articleId = :articleId";

		
//		org.hibernate.query.Query query = session.createQuery(hql);
//		session.createQuery(hql);
//		Discussion discussion = session.get(Discussion.class, views);
		
//	======
//		Integer views;
//		Discussion discussion = session.get(Discussion.class, articleId);
//		views = discussion.getViews();
//		System.out.println("views:"+views);
//	======
		
//		views = views++;
//		(Discussion)getSession().get(Discussion.class, views);
		
		Discussion discussion = session.get(Discussion.class, articleId);
//		return result;
		return discussion;
	}

	@Override
	public void addArticle(Discussion discussion) {
		Session session = factory.getCurrentSession();
		session.save(discussion);
	}

}
