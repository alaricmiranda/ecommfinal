package com.ecomm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

@Entity
@Table
public class User {
@Id
@GeneratedValue()
private int userId;
private String userEmailId;
@Column(name = "userName", unique = true, 
nullable = false, length = 45)
private String userName;
private String userContact;
private String userAddress;
private String userPassword;
private String userRole="ROLE_USER";
@Column(name="Enabled")
boolean enabled =true;
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserEmailId() {
	return userEmailId;
}
public void setUserEmailId(String userEmailId) {
	this.userEmailId = userEmailId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserContact() {
	return userContact;
}
public void setUserContact(String userContact) {
	this.userContact = userContact;
}
public String getUserAddress() {
	return userAddress;
}
public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}

}