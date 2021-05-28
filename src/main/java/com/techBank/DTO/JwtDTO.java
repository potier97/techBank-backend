package com.techBank.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String document;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDTO(String token, String document, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.document = document;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getNombreUsuario() {
        return document;
    }

    public void setNombreUsuario(String document) {
        this.document = document;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}