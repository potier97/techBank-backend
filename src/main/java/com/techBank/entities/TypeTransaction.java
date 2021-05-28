package com.techBank.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_type_transactions")
public class TypeTransaction implements Serializable  {
	
private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	private int id_type_transaction;
	
	private String transactionsType;

	public int getId_type_transaction() {
		return id_type_transaction;
	}

	public void setId_type_transaction(int id_type_transaction) {
		this.id_type_transaction = id_type_transaction;
	}

	public String getTransactionsType() {
		return transactionsType;
	}

	public void setTransactionsType(String transactionsType) {
		this.transactionsType = transactionsType;
	}
	 
 
}
