package com.eeit109team6.finalproject.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "news")
public class News {

	@Transient
	private Integer game_;
	@Transient
	private Integer newsType_;
	@Transient
	private Integer activity_;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer newsId;
	private String title;
	private Date publicationDate;
	private String article;
	private Integer likes;
	private Integer views;
	private Boolean isVisable;
	private String ipAddress;
	private Date lastUpdated;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	private Set<Message> messages = new HashSet<Message>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "news", cascade = CascadeType.ALL)
	private Set<ArticlePicture> articlePictures = new HashSet<ArticlePicture>();
	//單向多對一
	@JoinColumn(name = "GAMEID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Game game;
	@JoinColumn(name = "ACTIVITYID")
	@ManyToOne(fetch = FetchType.LAZY)
	private Activity activity;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID")
	private Member member;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
		
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

//	@ManyToMany(mappedBy = "likedNewses")
//	private Set<Member> memberLikes =new HashSet<Member>();
	@JoinColumn(name = "NEWSTYPEID")
	@ManyToOne(fetch = FetchType.LAZY)
	private NewsType newsType;
	

	public News() {
	}

	public Integer getActivity_() {
		return activity_;
	}

	public void setActivity_(Integer activity_) {
		this.activity_ = activity_;
	}

	public Integer getGame_() {
		return game_;
	}

	public void setGame_(Integer game_) {
		this.game_ = game_;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
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

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
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
