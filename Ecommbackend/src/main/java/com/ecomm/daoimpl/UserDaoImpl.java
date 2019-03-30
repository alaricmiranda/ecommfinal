package com.ecomm.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.dao.UserDao;
import com.ecomm.model.Category;
import com.ecomm.model.User;
 

@Repository("userDAO")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean add(User user) {
		
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	
	}
@Transactional
	public boolean delete(User userId) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().delete(userId);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
@Transactional
	public boolean update(User userId) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().update(userId);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public List<User> listUsers() {
		try {
			//Session session = sessionFactory.openSession();
			
			List<User> userList = (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
			
			
			
			return userList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
@Transactional
	public User getUser(int userId) {
		try {
			//Session session = sessionFactory.openSession();
			System.out.println("fetching user pointer");
			User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userId=:userId").setInteger("userId", userId).uniqueResult();
			System.out.println("forwarding pointer");
			return user;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

@Transactional
public User getUserbyName(String userName) {
	try {
		//Session session = sessionFactory.openSession();
		System.out.println("fetching user pointer");
		User user = (User) sessionFactory.getCurrentSession().createQuery("from User where userName=:userName").setString("userName", userName).uniqueResult();
		System.out.println("forwarding pointer");
		return user;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
@Transactional
public int getUserIDbyName(String userName) {
	try {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("fetching user pointer for ");
		System.out.println(userName);
		User user = (User) session.createQuery("from User where userName=:userName").setString("userName", userName).uniqueResult();
		System.out.println("forwarding pointer");
		System.out.println(user.getUserId());
		return user.getUserId();
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
}

		
	
	
	
}