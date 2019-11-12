package com.eeit109team6.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderbackController {

	@RequestMapping("/Orderback")
	public String Orderback(Model model) {

		return "showOrdersBack";
	}
}
