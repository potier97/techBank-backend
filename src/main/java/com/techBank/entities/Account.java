package com.techBank.entities;

import java.io.Serializable; 
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_accounts")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	private long id_account;
	
	private long id_client;
	
	private int id_type_account;
	
	private int id_office;
	
	private long balance;
	
	private int enabled;
	
	private int keyCode;

	public long getId_account() {
		return id_account;
	}

	public void setId_account(long id_account) {
		this.id_account = id_account;
	}

	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public int getId_type_account() {
		return id_type_account;
	}

	public void setId_type_account(int id_type_account) {
		this.id_type_account = id_type_account;
	}

	public int getId_office() {
		return id_office;
	}

	public void setId_office(int id_office) {
		this.id_office = id_office;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(int keyCode) {
		this.keyCode = keyCode;
	}  

}
