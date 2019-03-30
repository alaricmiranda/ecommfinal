package com.ecomm.dao;

import java.util.List;


import com.ecomm.model.Supplier;;

public interface SupplierDao {
	
	public boolean add(Supplier subpplier);
	public boolean delete(Supplier subpplier);
	public boolean update(Supplier subpplier);
	public List<Supplier> listSuppliers();
	public Supplier getSupplier(int supplierId);

}
