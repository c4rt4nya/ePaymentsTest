package com.epayment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TRANSFER")
public class Transfer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "SOURCE_ACCOUNT")
	private Account sAccount;

	@OneToOne
	@JoinColumn(name = "DESTINATION_ACCOUNT")
	private Account destAccount;

	@Column(nullable = false)
	private Double amount;

	public Transfer() {

	}

	public Transfer(Account sAccount, Account destAccount, Double amount) {
		this.sAccount = sAccount;
		this.destAccount = destAccount;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getsAccount() {
		return sAccount;
	}

	public void setsAccount(Account sAccount) {
		this.sAccount = sAccount;
	}

	public Account getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(Account destAccount) {
		this.destAccount = destAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", sAccount=" + sAccount + ", destAccount=" + destAccount + ", amount=" + amount
				+ "]";
	}

}
