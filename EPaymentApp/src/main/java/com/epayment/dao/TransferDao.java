package com.epayment.dao;

import com.epayment.entity.Transfer;

public interface TransferDao {

	/**
	 * Add a new transfer
	 * 
	 * @param transfer
	 */
	public void addTransfer(Transfer transfer);

}
