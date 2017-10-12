package com.epayment.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epayment.dao.TransferDao;
import com.epayment.entity.Transfer;
import com.epayment.service.AccountService;
import com.epayment.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferDao transferDao;

	@Autowired
	private AccountService accountService;

	@Override
	@Transactional
	public void addTransfer(Transfer transfer) throws Exception {
		transferDao.addTransfer(transfer);
		accountService.changeBalance(transfer.getsAccount(), transfer.getDestAccount(), transfer.getAmount());
	}

}
