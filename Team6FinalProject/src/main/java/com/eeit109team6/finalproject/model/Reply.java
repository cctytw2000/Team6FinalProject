package com.eeit109team6.finalproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Reply")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replyId;	//回覆編號
//	private Integer articleId;	//所屬文章編號
	private String	author;		//作者
	private String 	replyBody;	//回覆本體
	private String 	postTimeStamp;//發文時間戳
	private String	modifyTimeStamp;//最後修文時間戳
//	private Boolean is_removed;	//是否被刪除
	
	
	
	public Reply(Integer replyId, String author, String replyBody, String postTimeStamp, String modifyTimeStamp) {
		super();
		this.replyId = replyId;
		this.author = author;
		this.replyBody = replyBody;
		this.postTimeStamp = postTimeStamp;
		this.modifyTimeStamp = modifyTimeStamp;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReplyBody() {
		return replyBody;
	}

	public void setReplyBody(String replyBody) {
		this.replyBody = replyBody;
	}

	public String getPostTimeStamp() {
		return postTimeStamp;
	}

	public void setPostTimeStamp(String postTimeStamp) {
		this.postTimeStamp = postTimeStamp;
	}

	public String getModifyTimeStamp() {
		return modifyTimeStamp;
	}

	public void setModifyTimeStamp(String modifyTimeStamp) {
		this.modifyTimeStamp = modifyTimeStamp;
	}

}
