package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.Orders;

public interface OrderService {
	void insertOrder(Orders order);
	public List<Orders> showOrder(Integer member_id);
	public Orders getOrderById(Integer order_id);
}
