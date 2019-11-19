package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eeit109team6.finalproject.dao.IReplyDao;
import com.eeit109team6.finalproject.model.Reply;
import com.eeit109team6.finalproject.service.IReplyService;

@Service
public class ReplyServiceImpl implements IReplyService {
	IReplyDao dao;
	

	public void setDao(IReplyDao dao) {
		this.dao = dao;
	}

	public ReplyServiceImpl() {
	}

	@Override
	public List<Reply> getReplyByArticle(Integer articleId) {
		return dao.getReplyByArticle(articleId);
	}

}
