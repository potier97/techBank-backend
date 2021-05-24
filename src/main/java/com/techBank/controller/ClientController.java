package com.techBank.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techBank.services.ClientService; 
import com.techBank.entities.Client; 

// A continuación, creamos el controlador de usuario que contiene todos los puntos finales REST. 
// Navegue hasta el paquete del controlador y cree una nueva clase llamada UserController y agregue lo siguiente:

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/clients")  
public class ClientController {
	
	@Autowired
	private ClientService clientService; 

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId){
		Optional<Client> oUser = clientService.findById(userId);
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Client clientDetails, @PathVariable(value = "id") Long userId){
		Optional<Client> client = clientService.findById(userId);
		if(!client.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		client.get().setDocument(clientDetails.getDocument());
		client.get().setId_type_document(clientDetails.getId_type_document());
		client.get().setName(clientDetails.getName());
		client.get().setLastName(clientDetails.getLastName());
		client.get().setMail(clientDetails.getMail());
		client.get().setDirection(clientDetails.getDirection());
		client.get().setPhone(clientDetails.getPhone());
		client.get().setPassword(clientDetails.getPassword());  
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){ 
		if(!clientService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		clientService.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Client> readAll(){ 
		List<Client> users = StreamSupport.stream(clientService.findAll().spliterator(), false)
				.collect(Collectors.toList()); 
		return users;
	} 
	
}