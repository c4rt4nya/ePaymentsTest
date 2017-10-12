package com.epayment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epayment.dao.AccountDao;
import com.epayment.entity.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	@PersistenceContext
	protected EntityManager entityManager;

	public void addAccount(Account account) {
		entityManager.persist(account);
	}

	public Account findAccount(Long id) {
		Account accountDB = null;
		accountDB = entityManager.find(Account.class, id);
		return accountDB;
	}

	public void updateAccount(Account account) {
		entityManager.merge(account);
	}

}
