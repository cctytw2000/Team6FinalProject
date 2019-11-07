package com.eeit109team6.finalproject.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "activity")
public class Activity {

	private Integer activityId;
	private String activityName;
	private Timestamp startingDate_time;
	private Date startingDate;
	private Date endingDate;
	private String location;
	private ActivityType activityType;
	private NewsType newsType;

	public Activity() {
	}

	@Id
	@Column(name = "ACTIVITYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITYTYPEID")
	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEWSTYPEID")
	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	@Column(name = "ACTIVITYNAME")
	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Column(name = "STARTINGDATE_TIME")
	public Timestamp getStartingDate_time() {
		return startingDate_time;
	}

	public void setStartingDate_time(Timestamp startingDate_time) {
		this.startingDate_time = startingDate_time;
	}

	@Column(name = "STARTINGDATE")
	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	@Column(name = "ENDINGDATE")
	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	@Column(name = "LOCATION")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
