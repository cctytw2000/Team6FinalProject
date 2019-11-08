package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;

public interface IActivityDao {
	void addActivityType(ActivityType activityType);
	List<ActivityType> getAllActivityTypes();
	ActivityType getActivityTypeById(Integer activityTypeId);
	void addActivity(Activity activity); 
//====================================================未完成====================================================		
	List<ActivityType> getAllActivities(); 
	void deleteActivityById(int activityId); 
	void updateActivityById(Activity activity); 
	public Activity getActivityById(int activityId);
	
	
	
	
}
