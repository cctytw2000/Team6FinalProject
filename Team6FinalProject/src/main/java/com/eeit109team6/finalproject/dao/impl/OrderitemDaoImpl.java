package com.eeit109team6.finalproject.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IOrderitemDao;
import com.eeit109team6.finalproject.model.OrderItem;

@Repository
public class OrderitemDaoImpl implements IOrderitemDao {

	SessionFactory factory;

	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public List<OrderItem> showOrder() {
		String hql = "FROM OrderItem";
		Session session = factory.getCurrentSession();		 
		return session.createQuery(hql).getResultList();
	}

}
