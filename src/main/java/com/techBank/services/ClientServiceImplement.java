package com.techBank.services;
   
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techBank.entities.Client;
import com.techBank.interfaces.ClientInterface;

@Service
public class ClientServiceImplement implements ClientService {

	@Autowired
	private ClientInterface clientInterface;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Client> findAll(){
		return clientInterface.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pegeable){
		return clientInterface.findAll(pegeable);
	} 
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Client> findById(Long id){
		return clientInterface.findById(id);
	}
	
	@Override
	@Transactional
	public Client save(Client client){
		return clientInterface.save(client);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id){
		clientInterface.deleteById(id);
	}
	
	@Override 
	@Transactional
	public Optional<Client> getByDocument(String document){
        return clientInterface.findByDocument(document);
    }
 
	@Override
	@Transactional
    public boolean existByDocument(String document){
        return clientInterface.existByDocument(document);
    }

	@Override
	@Transactional
    public  boolean existByMail(String mail){
        return clientInterface.existByMail(mail);
    }
 
	
}
 
