package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.SupplierDao;
import com.ecomm.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDao supplierDAO;
	
	@RequestMapping(value="/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listSuppliers", listSuppliers); 
		return "Supplier";
	}
	
	@RequestMapping(value="/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddress")String supplierAddress,@RequestParam("supplierContact")String supplierContact,@RequestParam("supplierGmail")String supplierGmail,Model m)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		supplier.setSupplierContact(supplierContact);
		supplier.setSupplierGmail(supplierGmail);
			
		supplierDAO.add(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listSuppliers", listSuppliers); 
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierId}")
	public String deleteSuppplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		supplierDAO.delete(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listSuppliers", listSuppliers); 
		return "Supplier";
	}
	
	@RequestMapping(value="/editSupplier/{supplierId}")
	public String editSupplier(@PathVariable("supplierId")int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		m.addAttribute("supplier",supplier);
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/updateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("supplierId")int supplierId,@RequestParam("supplierName")String supplierName,@RequestParam("supplierAddress")String supplierAddress,@RequestParam("supplierContact")String supplierContact,@RequestParam("supplierGmail")String supplierGmail,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddress(supplierAddress);
		supplier.setSupplierContact(supplierContact);
		supplier.setSupplierGmail(supplierGmail);
		supplierDAO.update(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		//binding the listCategories and sending to jsp page
		m.addAttribute("listSuppliers", listSuppliers); 
		return "Supplier";
	}
}
