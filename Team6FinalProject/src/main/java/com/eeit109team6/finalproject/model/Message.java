package com.eeit109team6.finalproject.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {
	
	private Integer messageId;
	private String ipAddress;
	private Timestamp publicationDate;
	private Timestamp lastUpdated;
	private String memo;
	private Boolean isVisable;
	private News news;
//	private Member member;
	
	public Message() {
	}

	@Id
	@Column(name="MESSAGEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@Column(name = "IPADDRESS")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "PUBLICATIONDATE")
	public Timestamp getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Timestamp publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Column(name = "LASTUPDATED")
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name="MEMO")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "ISVISABLE")
	public Boolean getIsVisable() {
		return isVisable;
	}

	public void setIsVisable(Boolean isVisable) {
		this.isVisable = isVisable;
	}

	@ManyToOne
	@JoinColumn(name = "NEWSID")
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

//	@ManyToOne
//	@JoinColumn(name = "MEMBER_ID")
//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}
	
	
}
