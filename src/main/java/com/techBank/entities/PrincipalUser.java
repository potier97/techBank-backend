package com.techBank.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection; 
import java.util.List; 
import java.util.stream.Collectors;
 
 
public class PrincipalUser implements UserDetails {

	 
	private static final long serialVersionUID = 1L;
	
	
	private long id_client;
	private String document; 
    private Collection<?> id_type_document;
    private String name;
    private String lastName;
    private String mail;
    private String direction;
    private long phone;
    private String password; 
    private Collection<? extends GrantedAuthority> authorities;
 
	  

	public PrincipalUser(long id_client, String document, Collection<?> id_type_document, String name, String lastName,
			String mail, String direction, long phone, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id_client = id_client;
		this.document = document;
		this.id_type_document = id_type_document;
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
		this.direction = direction;
		this.phone = phone;
		this.password = password;
		this.authorities = authorities;
	}



	public static PrincipalUser build(Client client){
        List<GrantedAuthority> authorities =
        		client.getId_type_role().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolType().name())).collect(Collectors.toList());
        List<?> id_type_document =
        		client.getId_type_document().stream().map(document -> new SimpleGrantedAuthority(document.getDocumentType().name())).collect(Collectors.toList()); 
        return new PrincipalUser(client.getId_client(), client.getDocument(), id_type_document, client.getName(), client.getLastName(),
        		client.getMail(), client.getDirection(), client.getPhone(), client.getPassword(), authorities);
    }
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
		return authorities;
	}
 
	@Override
	public String getPassword() { 
		return password;
	}
 
	@Override
	public String getUsername() { 
		return document;
	}
 
	@Override
	public boolean isAccountNonExpired() { 
		return true;
	}
 
	@Override
	public boolean isAccountNonLocked() { 
		return true;
	}
  
	@Override
	public boolean isCredentialsNonExpired() { 
		return true;
	}
 
	@Override
	public boolean isEnabled() { 
		return true;
	}
 
	public String getDocument() {
		return document;
	}
  
	public String getName() {
		return name;
	}
 
	public String getLastName() {
		return lastName;
	}
  
	public String getMail() {
		return mail;
	}
 
	public String getDirection() {
		return direction;
	}
 
	public long getPhone() {
		return phone;
	}
	
	
	public long getId_client() {
		return id_client;
	} 

	public Collection<?> getId_type_document() {
		return id_type_document;
	}
 
	
	    
}
