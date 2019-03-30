package com.ecomm.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Product {
	@Id
	@GeneratedValue()
	private int productid;
	private String productname;
	private String price;
	private String quantity;
	private String productdetails;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getProductdetails() {
		return productdetails;
	}
	public void setProductdetails(String productdetails) {
		this.productdetails = productdetails;
	}
	

}