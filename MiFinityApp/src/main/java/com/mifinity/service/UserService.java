package com.mifinity.service;

import com.mifinity.entity.User;

public interface UserService {

	/**
	 * Add a new user
	 * @param user
	 */
	public void newUser(User user);
	
	/**
	 * Check if a user exist and return it
	 * @param user
	 * @return
	 */
	public User userExist(User user);
	
	/**
	 * Check if a user exist
	 * @param username
	 * @return
	 */
	public boolean userNameExist(String username);
}
