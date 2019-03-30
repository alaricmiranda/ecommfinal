package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.ProductDao;
import com.ecomm.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDao productDAO;
	
	@RequestMapping(value="/product")
	public String showProduct(Model m)
	{
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "Product";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProductDetail(@RequestParam("productname")String productname,@RequestParam("price")String price,@RequestParam("quantity")String quantity,@RequestParam("productdetails")String productdetails,Model m)
	{
		Product product=new Product();
		product.setProductname(productname);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setProductdetails(productdetails);
			
		productDAO.add(product);
		
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		productDAO.delete(product);
		
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{productId}")
	public String editProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		m.addAttribute("product",product);
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/updateProduct",method=RequestMethod.POST)
	public String updateProduct(@RequestParam("productId")int productId,@RequestParam("productname")String productname,@RequestParam("price")String price,@RequestParam("quantity")String quantity,@RequestParam("productdetails")String productdetails,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		product.setProductname(productname);
		product.setPrice(price);
		product.setQuantity(quantity);
		product.setProductdetails(productdetails);
		productDAO.update(product);
		
		List<Product> listProducts=productDAO.listProducts();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listProducts", listProducts); 
		return "Product";
	}
}
