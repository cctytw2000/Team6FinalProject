package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.Discussion;

public interface IDiscussionService {

	List<Discussion> getAllArticles();		// 取得所有文章
	List<Discussion> getArticleByBoardTypeId(Integer boardId);//取得指定看板的所有文章
	Discussion getArticleById(int articleId);//瀏覽單筆文章
	void addArticle(Discussion discussion);  //新增一筆文章(樓主)
	
	void updateViews(Integer id); //增加觀看次數
}
