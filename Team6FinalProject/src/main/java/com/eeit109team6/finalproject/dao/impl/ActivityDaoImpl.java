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

//====================================================未完成====================================================

	@Override
	public List<ActivityType> getAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteActivityById(int activityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateActivityById(Activity activity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Activity getActivityById(int activityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
