package com.mifinity.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifinity.dao.UserDao;
import com.mifinity.entity.User;
import com.mifinity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public void newUser(User user) {
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public User userExist(User user) {
		User persistedUser;
		persistedUser = userDao.getUserbyName(user.getUserName());
		if (persistedUser != null && !persistedUser.getPassword().equals(user.getPassword())) {
			persistedUser = null;
		}
		return persistedUser;
	}

	@Override
	@Transactional
	public boolean userNameExist(String username) {
		boolean exist = false;
		if (username != null) {
			User user = userDao.getUserbyName(username);
			if (user != null) {
				exist = true;
			}
		}

		return exist;
	}
}
