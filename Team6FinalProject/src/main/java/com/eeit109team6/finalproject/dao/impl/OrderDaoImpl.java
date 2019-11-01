package com.eeit109team6.finalproject.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IOrderDao;
import com.eeit109team6.finalproject.model.Orders;

@Repository
public class OrderDaoImpl implements IOrderDao {

	SessionFactory factory; 
	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void insertOrder(Orders order) {
		Session session = factory.getCurrentSession();
        session.save(order);
	}

}
