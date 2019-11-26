package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IDiscussionDao;
import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.model.Discussion;

@Repository
public class DiscussionDaoImpl implements IDiscussionDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<Discussion> getAllArticles() {

		String hql = "FROM Discussion d WHERE d.isDeleted = 0";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Discussion> getArticleByBoardTypeId(Integer boardId) {

		String hql = "FROM Discussion WHERE boardId = :boardId AND isDeleted = 0 ORDER BY articleId DESC";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("boardId", boardId).getResultList();

		return list;
	}
	
	@Override
	public List<Discussion> getArticleByBoardTypeIdBack(Integer boardId) {
		String hql = "FROM Discussion WHERE boardId = :boardId ORDER BY articleId DESC";
		List<Discussion> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("boardId", boardId).getResultList();

		return list;
	}

	@Override
	public void updateViews(Integer articleId) {

		Discussion discussion = factory.getCurrentSession().get(Discussion.class, articleId);
		discussion.setViews(discussion.getViews() + 1);
		factory.getCurrentSession().update(discussion);
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

	@Override
	public void updateBoardViews(Integer boardId) {
		BoardType boardType = factory.getCurrentSession().get(BoardType.class, boardId);
		boardType.setBoardViews(boardType.getBoardViews() + 1);
		factory.getCurrentSession().update(boardType);
		
	}

	@Override
	public List<Discussion> getArticleTop6() {
		String hql = "FROM Discussion d WHERE d.isDeleted = 0 ORDER BY views DESC";
		Session session = factory.getCurrentSession();
		List<Discussion> Dlist = session.createQuery(hql).setMaxResults(6).getResultList(); 
		return Dlist;
	}

	@Override
	public List<Discussion> getLatestArticle() {
		String hql = "FROM Discussion d WHERE d.isDeleted = 0 ORDER BY articleId DESC";
		Session session = factory.getCurrentSession();
		List<Discussion> Dlist = session.createQuery(hql).setMaxResults(10).getResultList(); 
		return Dlist;
	}

	@Override
	public List<BoardType> getBoardTopN() {		
		String hql = "FROM BoardType ORDER BY boardViews DESC";
		Session session = factory.getCurrentSession();
		List<BoardType> Blist = session.createQuery(hql).getResultList(); 
		return Blist;
	}

	@Override
	public void updateArticle(Discussion discussion) {
		Session session = factory.getCurrentSession();
		session.clear();
		session.update(discussion);
	}

	// �N�峹�w�R��
	@Override
	public void physicalDeleteArticleById(Integer articleId) {
		Session session = factory.getCurrentSession();
		Discussion discussion = session.get(Discussion.class, articleId);
		session.delete(discussion);
	}
	
	// �NisDeleted�אּ1�A�N�峹�аO�n�R���A����Ʈw�̵M�������C�Y�n�w�R���A�Х�physicalDeleteArticleById()
	@Override
	public void deleteArticleById(Integer articleId) {
		Session session = factory.getCurrentSession();
		Discussion discussion = session.get(Discussion.class, articleId);
		discussion.setIsDeleted(1);
		session.update(discussion);
	}
	
	// �NisDeleted�אּ0�A�ϧR���Q�аO���n�R�����峹�A��_���ϥΪ̥i���C
	@Override
	public void recoverArticleById(Integer articleId) {
		Session session = factory.getCurrentSession();
		Discussion discussion = session.get(Discussion.class, articleId);
		discussion.setIsDeleted(0);
		session.update(discussion);
	}
}
