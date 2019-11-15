package com.eeit109team6.finalproject.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		String hql = "FROM Orders  WHERE member_id = :member_id";
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

	@Override
	public Boolean updateOrderstate(Integer order_id) {
		String hql = "FROM Orders  WHERE order_id = :order_id AND state = 1";
		Query query=factory.getCurrentSession().createQuery(hql).setParameter("order_id", order_id);		
		try {
			Orders ordersList = (Orders) query.getSingleResult();
			ordersList.setState(4);
			factory.getCurrentSession().update(ordersList);
			return true;
		} catch (NoResultException e) {
			System.out.println("沒有未付款訂單");
			return false;
		}
	}
}
