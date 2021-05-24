package com.techBank.entities;
 
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="t_clients")
public class Client implements Serializable {

	private static final long serialVersionUID = 561837640739567975L; 
	 
    @Id
    @Column(name = "id_client", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;
     
    @Column(name = "document", nullable=false, unique=true, length=80) 
    private Long document;
 
    @Column(name = "id_type_document") 
    private int id_type_document;
 
    @Column(name = "name", length=20) 
    private String name;	
 
    @Column(name = "lastName", length=20) 
    private String lastName;	
 
    @Column(name = "mail", length=50) 
    private String mail;
 
    @Column(name = "direction", length=80) 
    private String direction;
 
    @Column(name = "phone", length=15) 
    private int phone;
 
    @Column(name = "password", length=20) 
    private String password;

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public Long getDocument() {
		return document;
	}

	public void setDocument(Long document) {
		this.document = document;
	}

	public int getId_type_document() {
		return id_type_document;
	}

	public void setId_type_document(int id_type_document) {
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
	
}
