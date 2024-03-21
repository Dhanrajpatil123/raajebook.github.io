package com.dao;

import com.entity.User;

public interface UserDao {
	
	
	public boolean userRegister(User us);	// pass the object of user class

	
/*
 * we are taking User as a return type because we want whole data from user table	
 */
	public User login(String email, String password);
	
	
	public boolean checkPassword(int id, String ps);
	
	public boolean updateProfile(User us);
	
	public boolean checkUser(String email);
}

