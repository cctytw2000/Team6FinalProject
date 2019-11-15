package com.eeit109team6.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.OrderService;
import com.eeit109team6.finalproject.service.OrderitemService;

@Controller
public class OrderitemController {

	OrderitemService observice;

	@Autowired
	public void setService(OrderitemService service) {
		this.observice = service;
	}

	IMemberService mservice;

	@Autowired
	public void setMservice(IMemberService mservice) {
		this.mservice = mservice;
	}

	OrderService oservice;

	@Autowired
	public void setOservice(OrderService oservice) {
		this.oservice = oservice;
	}

	// 訂單總覽-->後台showOrdersBack.jsp
	@RequestMapping("/ordersBack")
	public String showOrdersBack(Model model) {
		model.addAttribute("orders", observice.showOrders());
		model.addAttribute("members", mservice.findAll());
		return "showOrdersBack";
	}

	// 查詢個人訂單
	@RequestMapping(value = "/memberOrder/{member_id}.json")
	public void memberOrder(@PathVariable("member_id") Integer member_id, Model model) {
		model.addAttribute("list", oservice.showOrder(member_id));
	}

	// 查詢訂單細項
	@RequestMapping(value = "/orderDeail/{order_id}.json")
	public void orderDeail(@PathVariable("order_id") Integer order_id, Model model) {
		model.addAttribute("order", oservice.getOrderById(order_id));
	}
}
