package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Product;

public interface IProductDao {

	List<Product> getAllProducts(); //查詢所有商品
	public Product getProductById(int game_id); //依照id查詢單筆商品詳細資訊
	List<String> getAllCategories(); //查詢所有商品分類
	List<Product> getProductsByCategory(String category); //依照分類查詢商品 
	void addProduct(Product product); //新增商品
	void deleteProductById(int game_id); //刪除商品
	void updateProductById(Product product); //更新商品
}
