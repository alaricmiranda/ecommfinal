package com.ecomm.test;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDao;
import com.ecomm.model.Product;



public class ProductDAOTestCase {

	static ProductDao productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDao)context.getBean("productDAO");
	System.out.println("got bean prodcut");
	}
	
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductname("WindowCurtain");
		product.setPrice("WindowCurtain");
		product.setQuantity("WindowCurtain");
		product.setProductdetails("WindowCurtain");
	
		
		
		assertTrue("Problem in Adding the Product",productDAO.add(product));
	}
	
	
//	@Test
//	public void updateProductTest()
//	{	
//		Product product=productDAO.getProduct(75);
//		product.setProductdetails("Wash Basin and Front Glasses");	
//		assertTrue("Problem in Updating the Product",productDAO.update(product));
//	}
//	@Test
//	public void deleteProductTest()
//	{
//		Product product=productDAO.getProduct(75);
//		assertTrue("Problem in deleting the ProductC",productDAO.delete(product));
//	}
//	
	@Test
	public void listProductsTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		System.out.println("creted list object in test");
		
		assertTrue("Problem in Listing the Products",listProducts.size()>0);
		
		for(Product product:listProducts)
		{
			System.out.print("ProductID:"+product.getProductid());
			System.out.print("Product Name:"+product.getProductname());
			System.out.println("Product Desc:"+product.getProductdetails());
		}
	}

}
