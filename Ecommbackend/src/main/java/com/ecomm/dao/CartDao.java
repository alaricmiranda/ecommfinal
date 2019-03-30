package com.ecomm.dao;
import java.util.List;

import com.ecomm.model.Cart;
import com.ecomm.model.User;

public interface CartDao {
	public boolean add(Cart cart);
	public boolean delete(Cart cartId);
	public boolean update(Cart cartId);
	public List<Cart> listCart();
	public List<Cart> listCart(int userId);
	public Cart getCart(int cartId);
	public Cart getCartbyuser(int userId);
}
