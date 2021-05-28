package com.techBank.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.techBank.entities.Client;


//La clase de servicio contiene todos los métodos que manejan la lógica empresarial de la aplicación.
//Navegue hasta el paquete de servicios y cree una nueva clase Java llamada UserService. En aras de la brevedad, 
//solo crearé un servicio para agregar un nuevo usuario y recuperar todos los usuarios.


public interface ClientService {

	public Iterable<Client> findAll();
	 
	public Page<Client> findAll(Pageable pageable);
	
	public Optional<Client> findById(Long Id);
	
	public Client save(Client account);
	
	public void deleteById(Long id);

	public Optional<Client> getByDocument(String document);

	public boolean existByDocument(String document);

	public boolean existByMail(String mail);
	
	
	 
}
