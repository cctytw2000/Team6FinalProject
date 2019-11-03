package com.eeit109team6.finalproject.dao;

import java.util.List;

import com.eeit109team6.finalproject.model.Category;
import com.eeit109team6.finalproject.model.Product;

public interface IProductDao {

	List<Product> getAllProducts(); //查詢所有商品(不含已下架)
	public Product getProductById(int game_id); //依照id查詢單筆商品詳細資訊
	List<Category> getAllCategories(); //查詢所有商品分類
	List<Product> getProductsByCategory(Integer category_id); //依照分類查詢商品(不含已下架)
	void addProduct(Product product); //新增商品
	void deleteProductById(int game_id); //刪除商品
	void updateProductById(Product product); //更新商品
	List<Product> getAll(); //查詢所有商品(含已下架)
	List<Product> getProductByKeyWord(String keyWord); //關鍵字查詢
	void addCategory(Category category); //新增商品分類
	Category getCategoryById(Integer category_id); //依分類id查詢分類，以便之後可新增、更新商品
}
