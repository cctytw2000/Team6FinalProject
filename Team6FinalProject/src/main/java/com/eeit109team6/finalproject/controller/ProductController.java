package com.eeit109team6.finalproject.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.ProductService;

@Controller
public class ProductController {
	ProductService service;

	@Autowired
	public void setService(ProductService service) {
		this.service = service;
	}

	// 查詢所有商品--> 商城前台 products.jsp
	@RequestMapping("/products")
	public String list(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		return "products";
	}

	// 商城管理 --> manager.jsp
	@RequestMapping("/manager")
	public String manager(Model model) {
		return "manager";
	}

	// 提供新增商品時的表單--> addProduct.jsp
	@RequestMapping(value = "/productsBack/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProduct";
	}

	// 新增商品--> 商城後台 productsBack.jsp
	@RequestMapping(value = "/productsBack/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("product") Product product) {
		Date date = new Date();
		product.setDate(date);
		service.addProduct(product);
		return "redirect:/productsBack";
	}

	// 依照分類查詢商品
	@RequestMapping("/queryCategory")
	public String getProductsByCategory(@RequestParam("category") String category, Model model) {
		List<Product> products = service.getProductsByCategory(category);
		model.addAttribute("products", products);
		return "products";
	}

	// 查詢所有商品分類並存入Model
	@ModelAttribute("categories")
	public List<String> getCategories() {
		return service.getAllCategories();
	}

	// 查詢單筆商品詳細資料--> product.jsp
	@RequestMapping("/product")
	public String getProductById(@RequestParam("game_id") Integer game_id, Model model) {
		Product product = service.getProductById(game_id);
		model.addAttribute("product", product);
		return "product";
	}

	// 查詢所有商品--> 商城後台 productsBack.jsp
	@RequestMapping("/productsBack")
	public String listBack(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		return "productsBack";
	}

	// 商品下架--> 商城後台 productsBack.jsp
	@RequestMapping("/products/delete")
	public String deleteProductById(@RequestParam("game_id") Integer game_id, Model model) {
		service.deleteProductById(game_id);
		List<Product> products = service.getAllProducts();
		model.addAttribute("products", products);
		return "redirect:/productsBack";
	}

	// 提供更新商品時的表單--> updateProduct.jsp
	@RequestMapping(value = "/products/update", method = RequestMethod.GET)
	public String getUpdateProductForm(@RequestParam("game_id") Integer game_id, Model model) {
		Product product = service.getProductById(game_id);
		model.addAttribute("product", product);
		return "updateProduct";
	}

	// 更新商品--> 商城後台 productsBack.jsp
	@RequestMapping(value = "/products/update", method = RequestMethod.POST)
	public String processUpdateProductForm(@ModelAttribute("product") Product product) {
		Date date = new Date();
		product.setDate(date);
		service.updateProductById(product);;
		return "redirect:/productsBack";
	}
	
	//取消
//	@RequestMapping("/products/cancel")
//	public String cancel(Model model) {
//		List<Product> products = service.getAllProducts();
//		model.addAttribute("products", products);
//		return "redirect:/productsBack";
//	}
	
	// 查詢所有商品(含已下架)--> 商城後台 productsBack.jsp
	@RequestMapping("/productsBack/all")
	public String getAll(Model model) {
		List<Product> list = service.getAllProducts();
		model.addAttribute("products", list);
		return "redirect:/productsBack";
	}
}