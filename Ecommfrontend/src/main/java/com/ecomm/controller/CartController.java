package com.ecomm.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.ProductDao;
import com.ecomm.model.Product;
import com.ecomm.dao.CartDao;
import com.ecomm.model.Cart;
import com.ecomm.dao.UserDao;
import com.ecomm.model.User;

@Controller
public class CartController {
	@Autowired
	ProductDao productDAO;
	@Autowired
	CartDao cartDAO;
	@Autowired
	UserDao userDAO;
	
	@RequestMapping(value = "/cart")
	public String showCart(Model m)
	{ 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		int userId=userDAO.getUserIDbyName(userName);
		List<Cart> listCart=cartDAO.listCart(userId);
		int total=0;
		for (int i = 0; i < listCart.size(); i++) {
			Cart kart=listCart.get(i);
			total=((Integer.parseInt(kart.getPrice()))*kart.getQuantity())+total;
		}
		m.addAttribute("total", total);
		m.addAttribute("listCart", listCart);
		return "cart";
	}
	@RequestMapping(value="/addtocart-{productid}")
	public String deleteUser(@PathVariable("productid")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		Cart cart=new Cart();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		System.out.println(userName);
		int userId=userDAO.getUserIDbyName(userName);
		System.out.println(userId);
		cart.setUserId(userId);
		cart.setPrice(product.getPrice());
		cart.setProductdetails(product.getProductdetails());
		cart.setProductid(product.getProductid());
		cart.setProductname(product.getProductname());
		cart.setQuantity(1);
		cartDAO.add(cart);
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "index";	}
	@RequestMapping(value="/deleteCart-{cartId}")
	public String deleteProduct(@PathVariable("cartId")int cartId,Model m)
	{
		Cart cart=cartDAO.getCart(cartId);
		cartDAO.delete(cart);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		int userId=userDAO.getUserIDbyName(userName);
		List<Cart> listCart=cartDAO.listCart(userId);
		int total=0;
		for (int i = 0; i < listCart.size(); i++) {
			Cart kart=listCart.get(i);
			total=((Integer.parseInt(kart.getPrice()))*kart.getQuantity())+total;
		}
		m.addAttribute("total", total);
		//binding the listCategories and sending to jsp page
		m.addAttribute("listCart", listCart);
		return "cart";
	}
	
	@RequestMapping(value="/editCart/{cartId}")
	public String editProduct(@PathVariable("cartId")int cartId,Model m)
	{
		Cart cart=cartDAO.getCart(cartId);
		m.addAttribute("cart",cart);
		return "UpdateCart";
	}
	
	@RequestMapping(value="/updateCart",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("cartId")int cartId,@RequestParam("quantity")int quantity,@RequestParam("productname")String productname,Model m)
	{
		Cart cart=cartDAO.getCart(cartId);
		
		cart.setProductname(productname);
		cart.setQuantity(quantity);
		cartDAO.update(cart);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		int userId=userDAO.getUserIDbyName(userName);
		List<Cart> listCart=cartDAO.listCart(userId);
		int total=0;
		for (int i = 0; i < listCart.size(); i++) {
			Cart kart=listCart.get(i);
			total=((Integer.parseInt(kart.getPrice()))*kart.getQuantity())+total;
		}
		m.addAttribute("total", total);
		//binding the listCategories and sending to jsp page
		m.addAttribute("listCart", listCart);
		return "cart";
	}

}
