package com.eeit109team6.finalproject.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit109team6.finalproject.model.Member;
import com.eeit109team6.finalproject.model.OrderItem;
import com.eeit109team6.finalproject.model.Orders;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.OrderService;
import com.eeit109team6.finalproject.service.ProductService;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.domain.QueryTradeObj;
import ecpay.payment.integration.exception.EcpayException;

@Controller
public class AioCheckOutController {

	OrderService service;

	@Autowired
	public void setService(OrderService service) {
		this.service = service;
	}

	ProductService serviceP;

	@Autowired
	public void setServiceP(ProductService serviceP) {
		this.serviceP = serviceP;
	}

	AllInOne all;

	// 信用卡一次付清
	@RequestMapping(value = "/aioCheckOutOneTime", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public @ResponseBody String aioCheckOutDevide(@RequestParam("order_id") Integer order_id, HttpSession session) {
		System.out.println("進來了");
		Orders order = service.getOrderById(order_id);

		all = new AllInOne("");

		AioCheckOutOneTime aio = new AioCheckOutOneTime();

//		QueryTradeObj qto = new QueryTradeObj();
//		qto.set
//		String info = all.queryTrade(qto);

		InvoiceObj invoice = new InvoiceObj();
		// 模擬不開發票
		invoice = null;
		// 廠商系統自行產生
		String s = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
		aio.setMerchantTradeNo(s);

		// 廠商可自行決定交易時間
		String time = order.getOrdertime().replace(".0", "").replace("-", "/");
		aio.setMerchantTradeDate(time);

		// 從廠商DB撈出的商品資訊
		order.getOrderItems();
		String items = "";
		int i = order.getOrderItems().size();
		for (OrderItem item : order.getOrderItems()) {
			items += item.getProduct().getName();
			if (i > 1) {
				items += "#";
				i--;
			}
		}
		System.out.println("games:" + items);
		System.out.println("time:" + time);
		System.out.println("pay:" + s);
		System.out.println("game:" + order.getOrder_id().toString());
		aio.setItemName(items);
		aio.setTotalAmount(order.getTotal().toString());
		aio.setTradeDesc("item desc");
		// 廠商可自行決定是否延遲撥款
		aio.setHoldTradeAMT("0");
		// 後端設定付款完成通知回傳網址
		aio.setReturnURL("http://localhost:8080/Team6FinalProject/transaction?order_id=" + order_id);
		aio.setOrderResultURL("http://localhost:8080/Team6FinalProject/transaction?order_id=" + order_id);
		try {
			String html = all.aioCheckOut(aio, invoice);

			System.out.println("html === " + html);
			return html;
		} catch (EcpayException e) {
			throw new Error(e.getNewExceptionMessage());
		}

	}

	@RequestMapping(value = "/transaction")
	public String transaction(Model model, HttpSession session, @RequestParam("order_id") Integer order_id) {

		Boolean state = service.updateOrderstate(order_id);
		if (state) {
			Orders order = service.getOrderById(order_id);
			for (OrderItem oitem : order.getOrderItems()) {
				System.out.println(oitem.getProduct().getName());
				Product p = serviceP.getProductById(oitem.getProduct().getGame_id());
				p.setStock(p.getStock() - 1);
				serviceP.updateProductById(p);
			}
		}

		Member member = (Member) session.getAttribute("mem");
		if (member == null) {
			Member mem = new Member();
			mem.setAccount("sandy60108@yahoo.com.tw");
			mem.setPassword("a14789632");
			mem.setUsername("andy");
			model.addAttribute("Member", mem);
			model.addAttribute("msg", "您必須先登入!");
			return "jump";
		}

		List<Orders> list = service.showOrder(member.getMember_id());
		model.addAttribute("orders", list);

		Member mem = new Member();
		mem.setAccount("sandy60108@yahoo.com.tw");
		mem.setPassword("a14789632");
		mem.setUsername("andy");
		model.addAttribute("Member", mem);

		List<Product> listP = serviceP.getAllProducts();
		session.setAttribute("products", listP);
		return "showOrder";
	}

}
