package com.mifinity.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifinity.dao.CreditCardDao;
import com.mifinity.entity.CreditCard;
import com.mifinity.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	private static final int adminRole = 1;
	@Autowired
	private CreditCardDao creditCardDao;

	public void setCreditCardDao(CreditCardDao creditCardDao) {
		this.creditCardDao = creditCardDao;
	}

	@Override
	@Transactional
	public List<CreditCard> searchCreditCard(String cardNumber, long userId) {
		List<CreditCard> creditCardList = null;
		if (userId == adminRole) {
			creditCardList = creditCardDao.findAllCreditCards(cardNumber);
		} else {
			creditCardList = creditCardDao.findCreditCardsByUser(cardNumber, userId);
		}
		return creditCardList;
	}

	@Override
	@Transactional
	public void addCard(CreditCard creditCard) {
		CreditCard persistedCreditCard = creditCardDao.getCreditCard(creditCard.getCardNumber());
		if (persistedCreditCard != null) {
			persistedCreditCard.setExpiryDate(creditCard.getExpiryDate());
			creditCardDao.updateCreditCard(persistedCreditCard);
		} else {
			creditCardDao.addCreditCard(creditCard);
		}
	}

}
