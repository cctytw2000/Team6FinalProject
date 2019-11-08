package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.Discussion;

public interface IDiscussionService {

	List<Discussion> getAllArticles();//文章列表
	Discussion getArticleById(int articleId);//瀏覽文章
	void addArticle(Discussion discussion);//新增主題
	
}
