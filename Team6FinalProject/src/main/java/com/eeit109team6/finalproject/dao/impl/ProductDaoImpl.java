package com.eeit109team6.finalproject.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eeit109team6.finalproject.dao.IProductDao;
import com.eeit109team6.finalproject.model.Category;
import com.eeit109team6.finalproject.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {

	SessionFactory factory; 
	@Autowired
	public void setSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public List<Product> getAllProducts() {
		String hql = "FROM Product p WHERE p.is_remove = 0";
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void addProduct(Product product) {
		Session session = factory.getCurrentSession();
		session.save(product);
	}

	@Override
	public List<Category> getAllCategories() {
//		String hql = "SELECT DISTINCT p.category FROM Product p";
		String hql = "FROM Category";
		Session session = factory.getCurrentSession();
		List<Category> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public List<Product> getProductsByCategory(Integer category_id) {
		String hql = "FROM Product p WHERE p.category_id = :category_id AND p.is_remove = 0";
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("category_id", category_id).getResultList();
		return list;
	}

	@Override
	public Product getProductById(int game_id) {
		Session session = factory.getCurrentSession();
		Product product = session.get(Product.class, game_id);
		return product;
	}

	//將is_remove改為1，表示商品已下架，但資料庫依然有紀錄
	@Override
	public void deleteProductById(int game_id) {
		Session session = factory.getCurrentSession();
		Product product = session.get(Product.class, game_id);
		product.setIs_remove(1);
		session.update(product);
	}

	@Override
	public void updateProductById(Product product) {
		Session session = factory.getCurrentSession();
		session.update(product);		
	}

	@Override
	public List<Product> getAll() {
		String hql = "FROM Product";
		List<Product> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public List<Product> getProductByKeyWord(String keyWord) {
		String hql = "FROM Product p where p.name LIKE'%"+keyWord+"%'"; 
		Session session = factory.getCurrentSession();
		List<Product> list = session.createQuery(hql).getResultList();
		return list;
	}

}