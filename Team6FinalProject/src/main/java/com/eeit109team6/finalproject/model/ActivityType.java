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
@Table(name="activitytype")
public class ActivityType {

	private Integer activityTypeId;
	private String activityTypeName;
	private Set<Activity> activities = new HashSet<Activity>();
	
	public ActivityType() {
	}

	@Id
	@Column(name="ACTIVITYTYPEID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getActivityTypeId() {
		return activityTypeId;
	}

	public void setActivityTypeId(Integer activityTypeId) {
		this.activityTypeId = activityTypeId;
	}

	@Column(name="ACTIVITYTYPENAME")
	public String getActivityTypeName() {
		return activityTypeName;
	}

	public void setActivityTypeName(String activityTypeName) {
		this.activityTypeName = activityTypeName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activityType", cascade = CascadeType.ALL)
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	

}
