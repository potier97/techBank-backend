package com.techBank.services;

   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service; 
import com.techBank.entities.Client;
import com.techBank.entities.PrincipalUser;
import com.techBank.interfaces.ClientInterface;

@Service
public class ClientDetailsImplement implements UserDetailsService {

	@Autowired
	private ClientInterface clientInterface;

	@Override
	public UserDetails loadUserByUsername(String document) throws UsernameNotFoundException {
		Client client = clientInterface.findByDocument(document).get();
        return PrincipalUser.build(client);
	}
	 
	

}
