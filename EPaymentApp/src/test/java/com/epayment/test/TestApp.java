package com.epayment.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.epayment.dao.AccountDao;
import com.epayment.entity.Account;
import com.epayment.service.impl.AccountServiceImpl;

public class TestApp {

	private AccountServiceImpl accountService;
	private AccountDao accountDaoMock;

	@Before
	public void setUp() {
		accountDaoMock = Mockito.mock(AccountDao.class);
		accountService = new AccountServiceImpl();
		accountService.setAccountDao(accountDaoMock);
	}

	@Test
	public void addAccount() throws Exception {

		Account account = accountService.addAccount(new Account("test", 500d));
		assertEquals("test", account.getName());
		assertNotNull(account.getBalance());
	}

}
