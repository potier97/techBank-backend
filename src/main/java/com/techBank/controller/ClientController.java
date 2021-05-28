package com.techBank.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techBank.entities.ResourceNotFoundException; 
import com.techBank.services.ClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.techBank.entities.Client; 

// A continuación, creamos el controlador de usuario que contiene todos los puntos finales REST. 
// Navegue hasta el paquete del controlador y cree una nueva clase llamada UserController y agregue lo siguiente:

@ApiOperation(value="/api/clients", tags= "Clients profile Controller")
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/clients")  
public class ClientController {
	
	@Autowired
	private ClientService clientService; 
	
	@Autowired
	private BCryptPasswordEncoder encoderPass; 

	//Obtener todos los usuarios
	@ApiOperation(value="Feth all Clients", notes="Operacion Get", tags="listar", response= Iterable.class)
	@ApiResponses( value = {
				@ApiResponse(code = 200, message = "SUCCESS", response= Client.class, responseContainer = "List" ),
				@ApiResponse(code = 400, message = "NOT FOUND")
	})
	@GetMapping
	public List<Client> readAllClients(){ 
		List<Client> users = StreamSupport.stream(clientService.findAll().spliterator(), false)
				.collect(Collectors.toList()); 
		return users;
	} 
	
	//Obtener cliente por Id
	@ApiOperation(value="Feth client by Id", notes="Operacion Get", tags="listar",  response= Client.class)
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
	throws ResourceNotFoundException {
		Client client = clientService.findById(clientId).
			orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
        	return ResponseEntity.ok().body(client); 
    }
	 
	//Crear un nuevo cliente
	@ApiOperation(value="Create new client", notes="Operacion Post", tags="listar",  response= Client.class)
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client newClient)
	throws ResourceNotFoundException {  
		newClient.setPassword(encoderPass.encode(newClient.getPassword()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(newClient));
	}
	 
	
	//Editar cliente por Id
	@ApiOperation(value="Edit client by Id", notes="Operacion Put", tags="listar", response= Client.class)
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client clientDetails, @PathVariable(value = "id") Long clientId)
	throws ResourceNotFoundException {
		Client client = clientService.findById(clientId)
            .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId)); 
		client.setDocument(clientDetails.getDocument());
		client.setId_type_document(clientDetails.getId_type_document());
		client.setName(clientDetails.getName());
		client.setLastName(clientDetails.getLastName());
		client.setMail(clientDetails.getMail());
		client.setDirection(clientDetails.getDirection());
		client.setPhone(clientDetails.getPhone());
		//client.setPassword(clientDetails.getPassword());   
        final Client updatedClient = clientService.save(client);
        return ResponseEntity.ok(updatedClient);  
	}
	
	//Eliminar cliente por Id
	@ApiOperation(value="Delete client by Id", notes="Operacion Delete", tags="listar",  response= Client.class)
	@DeleteMapping("/{id}")
	public ResponseEntity<Client> deleteClient(@PathVariable(value = "id") Long clientId)
	throws ResourceNotFoundException {
		Client client = clientService.findById(clientId)
            .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId)); 
		clientService.deleteById(clientId);
		return ResponseEntity.ok().body(client); 
	}
	
}