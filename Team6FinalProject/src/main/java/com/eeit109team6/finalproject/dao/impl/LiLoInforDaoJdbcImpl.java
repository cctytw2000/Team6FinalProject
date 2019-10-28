package com.eeit109team6.finalproject.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.ILiLoInforDao;
import com.eeit109team6.finalproject.model.LiLoInfo;


@Repository
public class LiLoInforDaoJdbcImpl implements ILiLoInforDao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public LiLoInforDaoJdbcImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Boolean add(LiLoInfo l) {
	
		sessionFactory.getCurrentSession().save(l);
		
		return true;

	}

}
