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
import javax.persistence.Transient;

@Entity
@Table(name="news")
public class News {

	@Transient
	private Integer newsType_;
	
	@Id
	@Column(name="NEWSID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer newsId;
	private String title;
	@Column(name="PUBLICATIONDATE")
	private Timestamp publicationDate; 
	@Column(name="ARTICLE")
	private String article;
	@Column(name="LIKES")
	private Integer likes;
	@Column(name="VIEWS")
	private Integer views;
	@Column(name="ISVISABLE")
	private Boolean isVisable; 
	@Column(name="IPADDRESS")
	private String ipAddress;
	@Column(name="LASTUPDATED")
	private Timestamp lastUpdated;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	private Set<Message> messages = new HashSet<Message>(); 
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	private Set<ArticlePicture> articlePictures =new HashSet<ArticlePicture>();
//	@ManyToMany(mappedBy = "likedNewses")
//	private Set<Member> memberLikes =new HashSet<Member>();
	@JoinColumn(name = "NEWSTYPEID")
	@ManyToOne(fetch = FetchType.LAZY)
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
	
	public Integer getNewsType_() {
		return newsType_;
	}

	public void setNewsType_(Integer newsType_) {
		this.newsType_ = newsType_;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

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

	public Timestamp getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Timestamp publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Boolean getIsVisable() {
		return isVisable;
	}

	public void setIsVisable(Boolean isVisable) {
		this.isVisable = isVisable;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

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
