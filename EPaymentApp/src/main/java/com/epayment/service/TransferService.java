package com.epayment.service;

import com.epayment.entity.Transfer;

public interface TransferService {

	/**
	 * Add a new transfer
	 * 
	 * @param transfer
	 * @throws Exception
	 */
	public void addTransfer(Transfer transfer) throws Exception;
}
