package com.eeit109team6.finalproject.service.impl;

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

}
