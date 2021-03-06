package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eeit109team6.finalproject.dao.IActivityDao;
import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;
import com.eeit109team6.finalproject.service.IActivityService;

@Service
public class ActivityServiceImpl implements IActivityService {

	public ActivityServiceImpl() {
	}

	IActivityDao dao;

	@Autowired
	public void setDao(IActivityDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void addActivityType(ActivityType activityType) {
		dao.addActivityType(activityType);
	}
	
	@Transactional
	@Override
	public List<ActivityType> getAllActivityTypes() {
		return dao.getAllActivityTypes();
	}
	
	@Transactional
	@Override
	public ActivityType getActivityTypeById(Integer activityTypeId) {
		return dao.getActivityTypeById(activityTypeId);
	}
	
	@Transactional
	@Override
	public void addActivity(Activity activity) {
		dao.addActivity(activity);
	}
	
	@Transactional
	@Override
	public List<Activity> getAllActivities() {
		return dao.getAllActivities();
	}
	
	@Transactional
	@Override
	public Activity getActivityById(Integer activityId) {
		return dao.getActivityById(activityId);
	}

//====================================================未完成====================================================

	



	@Override
	public void updateActivityById(Activity activity) {
		// TODO Auto-generated method stub

	}




	@Override
	public void deleteActivityById(Integer activityId) {
		// TODO Auto-generated method stub
		
	}

}
