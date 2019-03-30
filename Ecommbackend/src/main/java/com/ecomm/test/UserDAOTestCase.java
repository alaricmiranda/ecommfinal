package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDao;
import com.ecomm.model.User;
import com.ecomm.model.User;



public class UserDAOTestCase {
	static UserDao userDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=( UserDao)context.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setUserEmailId("WindowCurtain");
		user.setUserName("WindowCurtain");
		user.setUserContact("WindowCurtain");
		user.setUserAddress("WindowCurtain");
		user.setUserPassword("WindowCurtain");
	
		
		
		assertTrue("Problem in Adding the Product",userDAO.add(user));
	}
//	@Test
//	public void updateProductTest()
//	{	
//		User user=userDAO.getUser(4);
//		user.setUserEmailId("updated");	
//		assertTrue("Problem in Updating the Product",userDAO.update(user));
//	}
//	@Test
//	public void deleteProductTest()
//	{
//		
//		User user=userDAO.getUser(3);
//		assertTrue("Problem in deleting the ProductC",userDAO.delete(user));
//	}
	
	@Test
	public void listProductsTest()
	{
		List<User> listUsers=userDAO.listUsers();
		System.out.println("creted list object in test");
		
		assertTrue("Problem in Listing the Products",listUsers.size()>0);
	System.out.println("stage 2");	
		for(User user:listUsers)
		{
			System.out.print("ProductID:"+user.getUserId());
			System.out.print("Product Name:"+user.getUserName());
			System.out.println("Product Desc:"+user.getUserContact());
			
		}
	}
}
