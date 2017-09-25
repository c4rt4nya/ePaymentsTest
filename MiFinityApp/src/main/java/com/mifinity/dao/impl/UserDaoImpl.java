package com.mifinity.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mifinity.dao.UserDao;
import com.mifinity.entity.Role;
import com.mifinity.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void addUser(User user) {
		Role role = new Role();
		//Set the role to 2 (user role)
		role.setId(2);
		user.setRole(role);
		entityManager.persist(user);
	}

	@Override
	public User getUserbyName(String username) {
		User user;
		TypedQuery<User> query = entityManager.createQuery("from User user where user.userName like ?1", User.class);
		query.setParameter(1, username);
		try {
			user = query.getSingleResult();
		} catch (NoResultException exception) {
			user = null;
		}
		return user;
	}

}
