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
@Table(name = "activity")
public class Activity {

	@Transient
	private Integer activityType_;
	@Transient
	private Integer newsType_;

	@Id
	@Column(name = "ACTIVITYID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;
	@Column(name = "ACTIVITYNAME")
	private String activityName;
	@Column(name = "STARTINGDATE_TIME")
	private String startingDate_time;
	@Column(name = "STARTINGTIME_DATE")
	private String startingTime_date;
	@Column(name = "STARTINGDATE")
	private String startingDate;
	@Column(name = "ENDINGDATE")
	private String endingDate;
	@Column(name = "LOCATION")
	private String location;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTIVITYTYPEID")
	private ActivityType activityType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEWSTYPEID")
	private NewsType newsType;

	public Activity() {
	}

	public String getStartingTime_date() {
		return startingTime_date;
	}

	public void setStartingTime_date(String startingTime_date) {
		this.startingTime_date = startingTime_date;
	}

	public Integer getActivityType_() {
		return activityType_;
	}

	public void setActivityType_(Integer activityType_) {
		this.activityType_ = activityType_;
	}

	public Integer getNewsType_() {
		return newsType_;
	}

	public void setNewsType_(Integer newsType_) {
		this.newsType_ = newsType_;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public NewsType getNewsType() {
		return newsType;
	}

	public void setNewsType(NewsType newsType) {
		this.newsType = newsType;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getStartingDate_time() {
		return startingDate_time;
	}

	public void setStartingDate_time(String startingDate_time) {
		this.startingDate_time = startingDate_time;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
