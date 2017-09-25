package com.mifinity.service;

import java.util.List;

import com.mifinity.entity.CreditCard;

public interface CreditCardService {

	/**
	 * Search the credit cards by a card number and a user id
	 * 
	 * @param cardNumber
	 * @param userId
	 * @return
	 */
	public List<CreditCard> searchCreditCard(String cardNumber, long userId);

	/**
	 * Add a credit card
	 * 
	 * @param creditCard
	 */
	public void addCard(CreditCard creditCard);

}
