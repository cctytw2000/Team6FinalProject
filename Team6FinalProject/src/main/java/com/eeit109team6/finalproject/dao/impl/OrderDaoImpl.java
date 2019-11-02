package com.eeit109team6.finalproject.dao.impl;

import java.util.List;

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

	@Override
	public List<Orders> showOrder(Integer member_id) {
		String hql = "FROM Orders  WHERE member_id = :member_id AND state = 1";
		Session session = factory.getCurrentSession();
		List<Orders> list = session.createQuery(hql).setParameter("member_id", member_id).getResultList();
		return list;
	}

	@Override
	public Orders getOrderById(Integer order_id) {
		String hql = "FROM Orders  WHERE order_id = :order_id";
		Session session = factory.getCurrentSession();
		Orders order = (Orders) session.createQuery(hql).setParameter("order_id", order_id).getSingleResult();
		return order;
	}

}
