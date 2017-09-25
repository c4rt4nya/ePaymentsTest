package com.mifinity.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mifinity.dao.CreditCardDao;
import com.mifinity.entity.CreditCard;

@Repository
public class CreditCardDaoImpl implements CreditCardDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<CreditCard> findCreditCardsByUser(String cardNumber, long userId) {
		TypedQuery<CreditCard> query = entityManager
				.createQuery("from CreditCard c where c.cardNumber like ?1 and user.id like ?2", CreditCard.class);
		query.setParameter(1, "%" + cardNumber + "%");
		query.setParameter(2, userId);
		return query.getResultList();
	}

	public List<CreditCard> findAllCreditCards(String cardNumber) {
		TypedQuery<CreditCard> query = entityManager.createQuery("from CreditCard c where c.cardNumber like ?1",
				CreditCard.class);
		query.setParameter(1, "%" + cardNumber + "%");
		return query.getResultList();
	}

	public void addCreditCard(CreditCard creditCard) {
		entityManager.persist(creditCard);
	}

	public void updateCreditCard(CreditCard creditCard) {
		entityManager.merge(creditCard);
	}

	public CreditCard getCreditCard(String cardNumber) {
		CreditCard card;
		TypedQuery<CreditCard> query = entityManager.createQuery("from CreditCard c where c.cardNumber like ?1",
				CreditCard.class);
		query.setParameter(1, cardNumber);
		try {
			card = query.getSingleResult();
		} catch (NoResultException exception) {
			card = null;
		}
		return card;
	}

}
