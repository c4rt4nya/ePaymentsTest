package com.mifinity.dao;

import java.util.List;

import com.mifinity.entity.CreditCard;

public interface CreditCardDao {

	/**
	 * Find credit cards by the card number and user id
	 * 
	 * @param cardNumber
	 * @param userId
	 * @return
	 */
	public List<CreditCard> findCreditCardsByUser(String cardNumber, long userId);

	/**
	 * Find credit cards by card number
	 * 
	 * @param cardNumber
	 * @return
	 */
	public List<CreditCard> findAllCreditCards(String cardNumber);

	/**
	 * Add a credit cart to the db
	 * 
	 * @param creditCard
	 */
	public void addCreditCard(CreditCard creditCard);

	/**
	 * Update an existing credit card
	 * 
	 * @param creditCard
	 */
	public void updateCreditCard(CreditCard creditCard);

	/**
	 * Get a credit cart by its card number
	 * 
	 * @param cardNumber
	 * @return
	 */
	public CreditCard getCreditCard(String cardNumber);

}
