package com.ecomm.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.dao.CartDao;
import com.ecomm.model.Cart;

@Repository("cartDAO")
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean add(Cart cart) {
		
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	
	}
@Transactional
	public boolean delete(Cart cartId) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().delete(cartId);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
@Transactional
	public boolean update(Cart cartId) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().update(cartId);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public List<Cart> listCart() {
		try {
			//Session session = sessionFactory.openSession();
			
			List<Cart> userList = (List<Cart>) sessionFactory.getCurrentSession().createQuery("from Cart").list();
			
			
			
			return userList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
@Transactional
public List<Cart> listCart(int userId) {
	try {
		//Session session = sessionFactory.openSession();
		
		List<Cart> userList = (List<Cart>) sessionFactory.getCurrentSession().createQuery("from Cart where userId=:userId").setInteger("userId", userId).list();
		
		
		
		return userList;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
@Transactional
	public Cart getCart(int cartId) {
		try {
			//Session session = sessionFactory.openSession();
			System.out.println("fetching user pointer");
			Cart cart = (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where cartId=:cartId").setInteger("cartId", cartId).uniqueResult();
			System.out.println("forwarding pointer");
			return cart;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

@Transactional
public Cart getCartbyuser(int userId) {
	try {
		//Session session = sessionFactory.openSession();
		System.out.println("fetching user pointer");
		Cart cart = (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where userId=:userId").setInteger("userId", userId).uniqueResult();
		System.out.println("forwarding pointer");
		return cart;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
}
