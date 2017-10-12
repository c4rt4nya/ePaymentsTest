package com.epayment.dao;

import com.epayment.entity.Account;

public interface AccountDao {

	/**
	 * Create a new account in the db
	 * 
	 * @param creditCard
	 */
	public void addAccount(Account account);

	/**
	 * Find an account in the db by its id
	 * 
	 * @param id
	 * @return
	 */
	public Account findAccount(Long id);

	/**
	 * Update and account, and persist it to the db
	 * 
	 * @param account
	 */
	public void updateAccount(Account account);
}
