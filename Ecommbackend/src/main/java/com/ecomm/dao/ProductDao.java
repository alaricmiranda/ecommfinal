package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Product;

public interface ProductDao {
	
	public boolean add(Product product);
	public boolean delete(Product product);
	public boolean update(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productId);

}	