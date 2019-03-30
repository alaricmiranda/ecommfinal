package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.User;

public interface UserDao {
	public boolean add(User userId);
	public boolean delete(User userId);
	public boolean update(User userId);
	public List<User> listUsers();
	public User getUser(int userId);
	public User getUserbyName(String userName);
	public int getUserIDbyName(String userName);

}
