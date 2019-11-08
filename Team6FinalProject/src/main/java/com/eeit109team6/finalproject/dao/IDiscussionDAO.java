package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Discussion;


public interface IDiscussionDAO {
	
	List<Discussion> getAllArticles();//文章列表
	Discussion getArticleById(int articleId);//瀏覽文章
	void addArticle(Discussion discussion);//新增主題
	
}
