package com.epayment.service;

import com.epayment.entity.Account;

public interface AccountService {

	/**
	 * Add an account
	 * 
	 * @param account
	 */
	public Account addAccount(Account account);

	/**
	 * Draw the balance from the source account and deposit the destination one
	 * 
	 * @param sourceAccount
	 * @param destAccount
	 * @param value
	 * @throws Exception
	 */
	public void changeBalance(Account sourceAccount, Account destAccount, Double value) throws Exception;

	/**
	 * Find an account by its id
	 * 
	 * @param id
	 * @return
	 */
	public Account findAccount(long id);;
}
