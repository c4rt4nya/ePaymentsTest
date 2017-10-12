package com.epayment.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epayment.dao.AccountDao;
import com.epayment.entity.Account;
import com.epayment.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	@Transactional
	public Account addAccount(Account account) {

		accountDao.addAccount(account);
		return account;
	}

	@Override
	@Transactional
	public void changeBalance(Account sourceAccount, Account destAccount, Double value) throws Exception {
		Account sourceAccountDB = findAccount(sourceAccount.getId());
		Account destAccountDB = findAccount(destAccount.getId());

		Double sourceBalance = sourceAccountDB.getBalance();

		if (sourceBalance >= value) {
			sourceAccountDB.setBalance(sourceBalance - value);
			destAccountDB.setBalance(destAccountDB.getBalance() + value);
			accountDao.updateAccount(sourceAccountDB);
			accountDao.updateAccount(destAccountDB);
		} else {
			throw new Exception("Transfer can not be done - Source account does not have enough balance");
		}
	}

	@Override
	@Transactional
	public Account findAccount(long id) {
		Account accountDB = null;
		accountDB = accountDao.findAccount(id);
		return accountDB;
	}

}
