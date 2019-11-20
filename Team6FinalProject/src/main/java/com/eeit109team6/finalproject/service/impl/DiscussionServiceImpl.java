package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IDiscussionDao;
import com.eeit109team6.finalproject.model.BoardType;
import com.eeit109team6.finalproject.model.Discussion;
import com.eeit109team6.finalproject.service.IDiscussionService;

@Service
public class DiscussionServiceImpl implements IDiscussionService {
	IDiscussionDao dao;

	@Autowired
	public void setDao(IDiscussionDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<Discussion> getAllArticles() {
		return dao.getAllArticles();
	}
	
	@Transactional
	@Override
	public List<Discussion> getArticleByBoardTypeId(Integer boardId) {
		return dao.getArticleByBoardTypeId(boardId);
	}

	@Transactional
	@Override
	public Discussion getArticleById(int articleId) {
		return dao.getArticleById(articleId);
	}

	@Transactional
	@Override
	public void addArticle(Discussion discussion) {
		dao.addArticle(discussion);
	}

	@Transactional
	@Override
	public void updateViews(Integer articleId) {
		dao.updateViews(articleId);
	}

	@Transactional
	@Override
	public void updateBoardViews(Integer boardId) {
		dao.updateBoardViews(boardId);	
	}
	
	@Transactional
	@Override
	public List<Discussion> getArticleTop6() {
		return dao.getArticleTop6();
	}
	
	@Transactional
	@Override
	public List<Discussion> getLatestArticle() {
		return dao.getLatestArticle();
	}

	@Override
	public List<BoardType> getBoardTopN() {
		return dao.getBoardTopN();
	}

}
