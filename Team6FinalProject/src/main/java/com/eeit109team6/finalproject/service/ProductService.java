package com.eeit109team6.finalproject.service;

import java.util.List;

import com.eeit109team6.finalproject.model.Category;
import com.eeit109team6.finalproject.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	public Product getProductById(int game_id);
	List<Category> getAllCategories();
	List<Product> getProductsByCategory(Integer category_id);
	void addProduct(Product product);
	void deleteProductById(int game_id);
	void updateProductById(Product product);
	List<Product> getAll();
	List<Product> getProductByKeyWord(String keyWord);
	void addCategory(Category category);
	Category getCategoryById(Integer category_id);
}
