package com.eeit109team6.finalproject.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Discussion")
public class Discussion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer articleId;	//文章編號
	private String subject;		//文章標題
	private String author;		//發文者顯示名稱
	@Transient					//忽略此屬性
	private Integer member_id;	//發文者會員編號
//	private Timestamp postTimeStamp;//發文時間戳
//	private Timestamp modifyTimeStamp;//最後修文時間戳
	private String memo;		//文章內文
//	private String ipAddress;	//發文ip位置
//	private Integer views;		//文章被瀏覽次數
//	private Boolean is_removed;	//是否被刪除
//	private Boolean is_locked;	//是否被鎖文
	


	public Discussion() {	//子類建構子呼叫父類建構子
		super();		
	}	

	
	public Discussion(Integer articleId, String subject, String author, Integer member_id, String memo) {
		super();
		this.articleId = articleId;
		this.subject = subject;
		this.author = author;
		this.member_id = member_id;
		this.memo = memo;
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
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
//	public Timestamp getPostTimeStamp() {
//		return postTimeStamp;
//	}
//	public void setPostTimeStamp(Timestamp postTimeStamp) {
//		this.postTimeStamp = postTimeStamp;
//	}
//	public Timestamp getModifyTimeStamp() {
//		return modifyTimeStamp;
//	}
//	public void setModifyTimeStamp(Timestamp modifyTimeStamp) {
//		this.modifyTimeStamp = modifyTimeStamp;
//	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
//	public String getIpAddress() {
//		return ipAddress;
//	}
//	public void setIpAddress(String ipAddress) {
//		this.ipAddress = ipAddress;
//	}
//	public Integer getViews() {
//		return views;
//	}
//	public void setViews(Integer views) {
//		this.views = views;
//	}
//	public Boolean getIs_removed() {
//		return is_removed;
//	}
//	public void setIs_removed(Boolean is_removed) {
//		this.is_removed = is_removed;
//	}
//	public Boolean getIs_locked() {
//		return is_locked;
//	}
//	public void setIs_locked(Boolean is_locked) {
//		this.is_locked = is_locked;
//	}
}
