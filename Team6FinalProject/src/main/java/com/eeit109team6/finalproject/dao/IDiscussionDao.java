package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Discussion;


public interface IDiscussionDao {
	
	List<Discussion> getAllArticles();		// 取得所有文章
	List<Discussion> getArticleByBoardTypeId(Integer boardId);//取得指定看板的所有文章
	Discussion getArticleById(int articleId);//瀏覽單筆文章
	void addArticle(Discussion discussion);  //新增一筆文章(樓主)
	void updateViews(Integer articleId);	//更新人氣
	
	
	//=================以下尚未撰寫
	//updateArticle();//修改文章
	//deleteArticle();//刪除文章
	
	
}
