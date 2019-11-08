package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;

public interface IActivityDao {
	void addActivityType(ActivityType activityType);
	List<ActivityType> getAllActivityTypes();
	ActivityType getActivityTypeById(Integer activityTypeId);
	void addActivity(Activity activity); 
	List<Activity> getAllActivities();
	public Activity getActivityById(Integer activityId);
//====================================================未完成====================================================		
	 
	void deleteActivityById(Integer activityId); 
	void updateActivityById(Activity activity); 
	
	
	
	
	
}
