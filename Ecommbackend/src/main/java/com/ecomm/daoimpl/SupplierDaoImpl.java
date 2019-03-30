package com.ecomm.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.dao.SupplierDao;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;
@Repository("supplierDAO")
public class SupplierDaoImpl implements SupplierDao {
          
	
	@Autowired	
        SessionFactory sessionFactory;
    	@Transactional
	public boolean add(Supplier supplier) {
    		try {
    			//Session session = sessionFactory.openSession();
    			sessionFactory.getCurrentSession().save(supplier);
    			return true;
    		} catch (HibernateException e) {
    			
    			e.printStackTrace();
    			return false;
    		}

	}
@Transactional
	public boolean delete(Supplier supplier) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().delete(supplier);
			
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Supplier supplier) {
		try {
			//Session session = sessionFactory.openSession();
			sessionFactory.getCurrentSession().update(supplier);
			
			
			return true;
		} catch (HibernateException e) {
		
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public List<Supplier> listSuppliers() {
		try {
			Session session = sessionFactory.openSession();
			
			List<Supplier> supplierList = (List<Supplier>) session.createQuery("from Supplier").list();
			
			
			
			return supplierList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
@Transactional
	public Supplier getSupplier(int supplierId) {
		try {
			Session session = sessionFactory.openSession();
			System.out.println("attempting to get supplier pointer");
			Supplier supplier = (Supplier) session.createQuery("from Supplier where supplierId=:supplierId").setInteger("supplierId", supplierId).uniqueResult();
			System.out.println("forwarding supplier pointer");
			return supplier;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
