package com.eeit109team6.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Discussion")
public class Discussion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer articleId; // 文章編號
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "boardId")// 本方資料表關聯欄位
	private BoardType boardType; // 所屬看板編號。外來鍵，使用對方類別宣告型態
	private String subject; // 文章標題
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "subjectTypeId")// 本方資料表關聯欄位
	private SubjectType subjectType;// 發文時的標題分類
	private String author; // 發文者顯示名稱
	private String articleBody; // 文章內文
	private String postTimeStamp;//發文時間戳
	private Integer views; // 文章被瀏覽次數
	
	
	public BoardType getBoardType() {
		return boardType;
	}

	public void setBoardType(BoardType boardType) {
		this.boardType = boardType;
	}	

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public Discussion() { // 子類建構子呼叫父類建構子
		super();
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getArticleBody() {
		return articleBody;
	}

	public void setArticleBody(String articleBody) {
		this.articleBody = articleBody;
	}

	public String getPostTimeStamp() {
		return postTimeStamp;
	}

	public void setPostTimeStamp(String postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}
}
