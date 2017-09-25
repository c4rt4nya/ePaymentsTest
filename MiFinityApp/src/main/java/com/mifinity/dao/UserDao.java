package com.mifinity.dao;

import com.mifinity.entity.User;

public interface UserDao {

	/**
	 * Add a user to the db
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * Get a user by its username
	 * 
	 * @param username
	 * @return
	 */
	public User getUserbyName(String username);

}
