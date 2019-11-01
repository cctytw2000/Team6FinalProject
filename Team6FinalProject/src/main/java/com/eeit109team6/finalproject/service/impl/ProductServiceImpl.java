package com.eeit109team6.finalproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eeit109team6.finalproject.dao.IProductDao;
import com.eeit109team6.finalproject.model.Product;
import com.eeit109team6.finalproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	IProductDao dao;
	@Autowired
	public void setDao(IProductDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Transactional
	@Override
	public void addProduct(Product product) {
		dao.addProduct(product);		
	}

	@Transactional
	@Override
	public List<String> getAllCategories() {
		return dao.getAllCategories();
	}

	@Transactional
	@Override
	public List<Product> getProductsByCategory(String category) {
		return dao.getProductsByCategory(category);
	}

	@Transactional
	@Override
	public Product getProductById(int game_id) {
		return dao.getProductById(game_id);
	}

	@Transactional
	@Override
	public void deleteProductById(int game_id) {
		dao.deleteProductById(game_id);		
	}

	@Transactional
	@Override
	public void updateProductById(Product product) {
		dao.updateProductById(product);
	}

	@Transactional
	@Override
	public List<Product> getAll() {
		return dao.getAll();
	}

	@Transactional
	@Override
	public List<Product> getProductByKeyWord(String keyWord) {
		return dao.getProductByKeyWord(keyWord);
	}

}
