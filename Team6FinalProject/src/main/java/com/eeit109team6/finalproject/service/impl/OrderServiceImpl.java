package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IOrderDao;
import com.eeit109team6.finalproject.model.Orders;
import com.eeit109team6.finalproject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	IOrderDao dao;

	@Autowired
	public void setDao(IOrderDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public void insertOrder(Orders order) {
		dao.insertOrder(order);

	}

	@Transactional
	@Override
	public List<Orders> showOrder(Integer member_id) {
		return dao.showOrder(member_id);
	}

	@Transactional
	@Override
	public Orders getOrderById(Integer order_id) {
		return dao.getOrderById(order_id);
	}

	@Transactional
	@Override
	public Boolean updateOrderstate(Integer order_id) {
		return dao.updateOrderstate(order_id);
	}

	@Transactional
	@Override
	public List<Orders> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public void deleteOrderById(Integer order_id) {
		dao.deleteOrderById(order_id);
	}
	
}
