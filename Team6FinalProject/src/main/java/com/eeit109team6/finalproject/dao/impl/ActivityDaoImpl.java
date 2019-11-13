package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IActivityDao;
import com.eeit109team6.finalproject.model.Activity;
import com.eeit109team6.finalproject.model.ActivityType;
import com.eeit109team6.finalproject.model.Game;
import com.eeit109team6.finalproject.model.GameType;

@Repository
public class ActivityDaoImpl implements IActivityDao {

	public ActivityDaoImpl() {
	}
	
	SessionFactory factory;

	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addActivityType(ActivityType activityType) {
		Session session = factory.getCurrentSession();
		session.save(activityType);
	}
	
	@Override
	public List<ActivityType> getAllActivityTypes() {
		String hql = "FROM ActivityType";
		Session session = factory.getCurrentSession();
		List<ActivityType> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
		}

	@Override
	public ActivityType getActivityTypeById(Integer activityTypeId) {
		Session session = factory.getCurrentSession();
		ActivityType activityType = session.get(ActivityType.class, activityTypeId);
		return activityType;
	}
	
	@Override
	public void addActivity(Activity activity) {
		Session session = factory.getCurrentSession();
		session.save(activity);
	}
	
	@Override
	public List<Activity> getAllActivities() {
		String hql = "FROM Activity";
		List<Activity> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	

	@Override
	public Activity getActivityById(Integer activityId) {
		Session session = factory.getCurrentSession();
		Activity activity = session.get(Activity.class, activityId);
		return activity;
	}
	
	@Override
	public void updateActivityTypeById(ActivityType activityType) {
		Session session = factory.getCurrentSession();
		session.clear();
		session.update(activityType);
	}

	@Override
	public void deleteActivityTypeById(Integer activityTypeId) {
		Session session = factory.getCurrentSession();
		ActivityType at = session.get(ActivityType.class, activityTypeId);
		session.delete(at);				
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
