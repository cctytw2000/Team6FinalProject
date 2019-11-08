package com.eeit109team6.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "game")
public class Game {

	@Transient
	private Integer gameType_;
	@Transient
	private Integer newsType_;

	@Id
	@Column(name = "GAMEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gameId;

	@Column(name = "GAMENAME")
	private String gameName;

	@Column(name = "PUBLICATIONDATE")
	private String publicationDate;

	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "PLATFORM")
	private String platform;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "newstypeid")
	private NewsType newsType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gametypeid")
	private GameType gameType;

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Game() {
	}

	@Transient
	public Integer getGameType_() {
		return gameType_;
	}

	@Transient
	public void setGameType_(Integer gameType_) {
		this.gameType_ = gameType_;
	}

	@Transient
	public Integer getNewsType_() {
		return newsType_;
	}

	@Transient
	public void setNewsType_(Integer newsType_) {
		this.newsType_ = newsType_;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

}
