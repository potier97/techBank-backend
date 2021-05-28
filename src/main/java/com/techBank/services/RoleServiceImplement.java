package com.techBank.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.techBank.entities.TypeRole;
import com.techBank.interfaces.RoleInterface;

import com.techBank.security.enums.RolName;

@Service
public class RoleServiceImplement implements RoleService {

	@Autowired
	private RoleInterface roleInterface;
	  

	@Override 
	@Transactional
	public Optional<TypeRole> findByRolType(RolName rolType){
      return roleInterface.findByRolType(rolType);
	}
  
	
}