package com.epayment.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.epayment.dao.TransferDao;
import com.epayment.entity.Transfer;

@Repository
public class TransferDaoImpl implements TransferDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void addTransfer(Transfer transfer) {
		entityManager.persist(transfer);
	}


}
