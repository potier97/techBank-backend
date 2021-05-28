package com.techBank.DTO;
 
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLogin {


    @NotBlank
    private String document;
  
    @NotBlank
    private String password;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
  
 
    
}