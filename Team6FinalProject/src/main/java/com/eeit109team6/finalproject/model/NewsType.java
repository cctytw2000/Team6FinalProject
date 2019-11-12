package com.eeit109team6.finalproject.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="newstype")
public class NewsType {

	@Id
	@Column(name="NEWSTYPEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer newsTypeId;
	@Column(name="NEWSTYPENAME", columnDefinition = "nvarchar")
	private String newsTypeName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsType", cascade = CascadeType.ALL)
	private Set<Game> games = new HashSet<Game>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsType", cascade = CascadeType.ALL)
	private Set<Activity> activities= new HashSet<Activity>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newsType", cascade = CascadeType.ALL)
	private Set<News> newses= new HashSet<News>();
	
	public NewsType() {
	}

	public Integer getNewsTypeId() {
		return newsTypeId;
	}

	public void setNewsTypeId(Integer newsTypeId) {
		this.newsTypeId = newsTypeId;
	}

	public String getNewsTypeName() {
		return newsTypeName;
	}

	public void setNewsTypeName(String newsTypeName) {
		this.newsTypeName = newsTypeName;
	}
	
	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	public Set<News> getNewses() {
		return newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}
	
	

}
