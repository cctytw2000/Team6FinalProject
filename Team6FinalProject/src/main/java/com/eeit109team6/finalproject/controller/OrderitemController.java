package com.eeit109team6.finalproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit109team6.finalproject.model.Orders;
import com.eeit109team6.finalproject.service.IMemberService;
import com.eeit109team6.finalproject.service.OrderService;
import com.eeit109team6.finalproject.service.OrderitemService;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	@RequestMapping(value = "/memberOrder", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> memberOrder(@RequestParam("member_id") Integer member_id) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Orders> list = oservice.showOrder(member_id);
		result.put("jsondata", toJson(list));
		return result;
	}

	public String toJson(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
