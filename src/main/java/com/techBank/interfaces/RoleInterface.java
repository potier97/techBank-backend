package com.techBank.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techBank.entities.TypeRole;
import com.techBank.security.enums.RolName; 


// A continuaci�n, creamos un objeto de acceso a datos que es una interfaz que extiende la interfaz JpaRepository. El DAO se utiliza para realizar operaciones de base de datos CRUD
// Navegue hasta el paquete dao y cree una interfaz llamada UserDao y agregue el siguiente c�digo:

@Repository
public interface RoleInterface extends JpaRepository<TypeRole, Long> {

	Optional<TypeRole> findByRolType(RolName rolType);
		 
	
}
