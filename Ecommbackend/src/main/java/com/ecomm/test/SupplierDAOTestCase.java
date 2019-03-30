package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.SupplierDao;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;



public class SupplierDAOTestCase {

	static SupplierDao supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDao)context.getBean("supplierDAO");
		System.out.println("supper dao found");
	}
	
	
	@Test
	public void addProductTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("WindowCurtain");
		supplier.setSupplierAddress("WindowCurtain");
		supplier.setSupplierContact("WindowCurtain");
		supplier.setSupplierGmail("WindowCurtain");
	     assertTrue("Problem in Adding the Product",supplierDAO.add(supplier));
	}
//	@Test
//	public void updateProductTest()
//	{	
//		Supplier supplier=supplierDAO.getSupplier(1);
//		supplier.setSupplierName("updated");	
//		assertTrue("Problem in Updating the Product",supplierDAO.update(supplier));
//	}
//	@Test
//	public void deleteProductTest()
//	{
//		Supplier supplier=supplierDAO.getSupplier(1);
//		assertTrue("Problem in deleting the ProductC",supplierDAO.delete(supplier));
//	}
	@Test
	public void listProductsTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		System.out.println("creted list object in test");
		
		assertTrue("Problem in Listing the Products",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print("ProductID:"+supplier.getSupplierId());
			System.out.print("Product Name:"+supplier.getSupplierName());
			System.out.println("Product Desc:"+supplier.getSupplierAddress());
			System.out.println(supplier.getSupplierContact());
			System.out.println(supplier.getSupplierGmail());
		}
	}
}
