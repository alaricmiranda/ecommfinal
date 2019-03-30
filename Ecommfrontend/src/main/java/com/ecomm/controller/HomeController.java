package com.ecomm.controller;


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
import com.ecomm.model.Cart;
import com.ecomm.model.Product;
@Controller
public class HomeController {
	@Autowired
	ProductDao productDAO;
	@RequestMapping(value = "/")
	public String showIndex(Model m)
	{ 
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "index";
	}
	@RequestMapping(value = "/contact")
	public String showContact()
	{ 
		return "contact";
	}

	@RequestMapping(value = "/log")
	public String showCart(Model m)
	{ 
		
		return "welcome";
	}

}
