package com.ecomm.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.dao.CategoryDao;
import com.ecomm.model.Category;



@Repository("categoryDAO")
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean add(Category category) {
			
		try {
			
			/*Session session = sessionFactory.openSession();
			System.out.println(category.getCategoryId()+" : "+category.getCategoryName()+" : "+category.getCategoryDesc());
			session.save(category);
			
			System.out.println("Category added");*/
			
			sessionFactory.getCurrentSession().save(category);
			
			return true;
		} catch (HibernateException e) {
			System.out.println("Errorrrr");
			
			e.printStackTrace();
			return false;
		}
	}
   @Transactional
	public boolean delete(Category category) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().delete(category);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public List<Category> listCategories() {
		try {
			Session session = sessionFactory.openSession();
			
			List<Category> categoryList = (List<Category>) session.createQuery("from Category").list();
			
			
			
			return categoryList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public Category getCategory(int categoryId) {
		try {
			//Session session = sessionFactory.openSession();
			
			Category category = (Category) sessionFactory.getCurrentSession().createQuery("from Category where categoryId=:categoryId").setInteger("categoryId", categoryId).uniqueResult();
			
			System.out.println("object retured");
			return category;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}