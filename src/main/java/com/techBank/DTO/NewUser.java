package com.techBank.DTO;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;  
import java.util.Set;


public class NewUser {
 
    @NotBlank
    private long id_client;

    @NotBlank
    private String document;
 
    @NotBlank
    private Set<String> id_type_document;
 
    @NotBlank
    private String name;	

    @NotBlank
    private String lastName;	 
   
    @NotBlank 
    @Email
    private String mail;
 
    @NotBlank
    private String direction;
  
    @NotBlank
    private long phone;
 
    @NotBlank
    private String password;
  
    @NotBlank
    private Set<String> id_type_role;

	public long getId_client() {
		return id_client;
	}

	public void setId_client(long id_client) {
		this.id_client = id_client;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Set<String> getId_type_document() {
		return id_type_document;
	}

	public void setId_type_document(Set<String> id_type_document) {
		this.id_type_document = id_type_document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getId_type_role() {
		return id_type_role;
	}

	public void setId_type_role(Set<String> id_type_role) {
		this.id_type_role = id_type_role;
	}
     
    
}