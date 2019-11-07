package com.eeit109team6.finalproject.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {

	private Integer newsId;
	private String title;
	private Timestamp publicationDate; 
	private String article;
	private Integer likes;
	private Integer views;
	private Boolean isVisable; 
	private String ipAddress;
	private Timestamp lastUpdated;
	private Set<Message> messages = new HashSet<Message>(); 
	private Set<ArticlePicture> articlePictures =new HashSet<ArticlePicture>();
//	@ManyToMany(mappedBy = "likedNewses")
//	private Set<Member> memberLikes =new HashSet<Member>();
	private NewsType newsType;
//	private Member member;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="MEMBER_ID")
//	public Member getMember() {
//		return member;
//	}
//
//	public void setMember(Member member) {
//		this.member = member;
//	}

	public News() {
	}

	@Id
	@Column(name="NEWSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	@JoinColumn(name = "NEWSTYPEID")
	@ManyToOne(fetch = FetchType.LAZY)
	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="PUBLICATIONDATE")
	public Timestamp getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Timestamp publicationDate) {
		this.publicationDate = publicationDate;
	}

	@Column(name="ARTICLE")
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	@Column(name="LIKES")
	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	@Column(name="VIEWS")
	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	@Column(name="ISVISABLE")
	public Boolean getIsVisable() {
		return isVisable;
	}

	public void setIsVisable(Boolean isVisable) {
		this.isVisable = isVisable;
	}

	@Column(name="IPADDRESS")
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name="LASTUPDATED")
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	public Set<ArticlePicture> getArticlePictures() {
		return articlePictures;
	}

	public void setArticlePictures(Set<ArticlePicture> articlePictures) {
		this.articlePictures = articlePictures;
	}

//	public Set<Member> getMemberLikes() {
//		return memberLikes;
//	}
//
//	public void setMemberLikes(Set<Member> memberLikes) {
//		this.memberLikes = memberLikes;
//	}

}
