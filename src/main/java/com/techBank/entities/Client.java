package com.techBank.entities;
 
import java.io.Serializable;
import javax.persistence.Entity; 
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;  

@Entity
@Table(name="t_clients")
@ApiModel(description="Clients Model")
public class Client implements Serializable {

	private static final long serialVersionUID = 561837640739567975L; 
 
    @Id 
    @ApiModelProperty(notes="ID_CLIENT on the Bank", name="id_client", required=true, value="25")
    private long id_client;

    @NotNull
    @ApiModelProperty(notes="DOCUMENT on the Bank", name="document", required=true, value="123456789")
    private String document;
 
    @NotNull
    @ApiModelProperty(notes="ID_TYPE_DOCUMENT on the Bank", name="id_type_document", required=true, value="1")
    @JoinTable(name = "t_type_documents", joinColumns = @JoinColumn(name = "id_type_document"), inverseJoinColumns = @JoinColumn(name = "id_type_document"))
    private Set<TypeDocument> id_type_document = new HashSet<>();
 
    @NotNull
    @ApiModelProperty(notes="NAME on the Bank", name="name", required=true, value="Jonh")
    private String name;	

    @NotNull
    @ApiModelProperty(notes="LASTNAME on the Bank", name="lastName", required=true, value="Due")
    private String lastName;	 
   
    @NotNull
    @ApiModelProperty(notes="MAIL on the Bank", name="mail", required=true, value="jonhDue@example.com")
    private String mail;
 
    @NotNull
    @ApiModelProperty(notes="DIRECTION on the Bank", name="direction", required=true, value="Cll 23 #32-34 Norte")
    private String direction;
 
    @NotNull
    @ApiModelProperty(notes="PHONE on the Bank", name="phone", required=true, value="2035622") 
    private long phone;
 
    @NotNull
    @ApiModelProperty(notes="PASSWORD on the Bank", name="password", required=true, value="Password*") 
    private String password;
  
    @NotNull
    @ApiModelProperty(notes="ID_TYPE_ROLE on the Bank", name="id_type_role", required=true, value="2") 
    @JoinTable(name = "t_type_roles", joinColumns = @JoinColumn(name = "id_type_role"), inverseJoinColumns = @JoinColumn(name = "id_type_role"))
    private Set<TypeRole> id_type_role = new HashSet<>();
    
    // public Client() {} 
    
    public Client(@NotNull String document, @NotNull String name, @NotNull String lastName, @NotNull String mail,  
    				@NotNull String direction, @NotNull long phone, @NotNull String password) {
        this.document = document;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.direction = direction;
        this.phone = phone;
        this.password = password; 
         
    }

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

	public Set<TypeDocument> getId_type_document() {
		return id_type_document;
	}

	public void setId_type_document(Set<TypeDocument> id_type_document) {
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

	public Set<TypeRole> getId_type_role() {
		return id_type_role;
	}

	public void setId_type_role(Set<TypeRole> id_type_role) {
		this.id_type_role = id_type_role;
	}
    
	 
  
}
