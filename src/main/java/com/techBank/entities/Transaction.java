package com.techBank.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_transactions")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	private long id_transaction;
	
	private int id_type_transaction;
	
	private long id_client;
	
	private long id_account;
	
	private LocalDate  transaction_date;
	
	private int result;
	
	private long amount;

	public long getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(int id_transaction) {
		this.id_transaction = id_transaction;
	}

	public int getId_type_transaction() {
		return id_type_transaction;
	}

	public void setId_type_transaction(int id_type_transaction) {
		this.id_type_transaction = id_type_transaction;
	}

	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public long getId_account() {
		return id_account;
	}

	public void setId_account(long id_account) {
		this.id_account = id_account;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}
	 
	
}
