package com.techBank.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techBank.entities.Client; 


// A continuación, creamos un objeto de acceso a datos que es una interfaz que extiende la interfaz JpaRepository. El DAO se utiliza para realizar operaciones de base de datos CRUD
// Navegue hasta el paquete dao y cree una interfaz llamada UserDao y agregue el siguiente código:

@Repository
public interface ClientInterface extends JpaRepository<Client, Long> {

}
 

 