package com.techBank.entities;
 
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_account_transactions") 
public class AccountTransaction {
	
	private long id_transaction;
	
	private long id_account;

	public long getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(long id_transaction) {
		this.id_transaction = id_transaction;
	}

	public long getId_account() {
		return id_account;
	}

	public void setId_account(long id_account) {
		this.id_account = id_account;
	}  
	
}
