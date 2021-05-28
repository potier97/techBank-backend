package com.techBank.services;

import java.util.Optional;
 
import com.techBank.entities.TypeRole;
import com.techBank.security.enums.RolName;

public interface RoleService {
 
	public Optional<TypeRole> findByRolType(RolName rolType);
	
}
 

 