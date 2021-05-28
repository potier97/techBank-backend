package com.techBank.entities;

import java.io.Serializable; 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_type_accounts")
public class TypeAccount implements Serializable  {

	private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	private int id_type_account;
	
	private String accountType;

	public int getId_type_account() {
		return id_type_account;
	}

	public void setId_type_account(int id_type_account) {
		this.id_type_account = id_type_account;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}  
	
}
