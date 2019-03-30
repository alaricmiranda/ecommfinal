package com.ecomm.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.dao.ProductDao;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
@Repository("productDAO")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean add(Product product) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().save(product);
			
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Product product) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().delete(product);
			return false;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
@Transactional
	public boolean update(Product product) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().update(product);
			return false;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public List<Product> listProducts() {
		try {
			Session session = sessionFactory.openSession();
			//System.out.println("in list product session created");
			List<Product> productList = (List<Product>) session.createQuery("from Product").list();
			//System.out.println("retrning list obj");
			return productList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
@Transactional
	public Product getProduct(int productId) {
		
		try {
			//Session session = sessionFactory.openSession();
			System.out.println("trying to get pointer");
			Product product = (Product) sessionFactory.getCurrentSession().createQuery("from Product where productId=:productId").setInteger("productId", productId).uniqueResult();
            System.out.println("obect returned");			
			
			return product;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}