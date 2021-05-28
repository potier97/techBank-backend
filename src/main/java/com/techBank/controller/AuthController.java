package com.techBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techBank.DTO.JwtDTO;
import com.techBank.DTO.UserLogin;
import com.techBank.DTO.Message;
import com.techBank.DTO.NewUser;
import com.techBank.entities.TypeRole;
import com.techBank.entities.Client;
import com.techBank.entities.TypeRole;
import com.techBank.security.jwt.JwtProvider;
import com.techBank.services.RoleServiceImplement;
import com.techBank.services.ClientServiceImplement;

import com.techBank.security.enums.RolName;



import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController { 

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ClientServiceImplement clientService;

    @Autowired
    RoleServiceImplement RoleServiceImpl;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if(clientService.existByDocument(nuevoUsuario.getDocument()))
            return new ResponseEntity(new Message("ese Docmento ya existe"), HttpStatus.BAD_REQUEST);
        if(clientService.existByMail(nuevoUsuario.getMail()))
            return new ResponseEntity(new Message("ese email ya existe"), HttpStatus.BAD_REQUEST);
        Client client = new Client(nuevoUsuario.getDocument(), 
        		nuevoUsuario.getName(), nuevoUsuario.getLastName(), nuevoUsuario.getMail(),
        		nuevoUsuario.getDirection(), nuevoUsuario.getPhone(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
       
		
		
        Set<String> rolesStr = nuevoUsuario.getId_type_role();
        Set<TypeRole> roles = new HashSet<>();
        if(nuevoUsuario.getId_type_document().contains("1")) {
        	roles.add(RoleServiceImpl.findByRolType(RolName.ROLE_ADMIN).get());
        }else {
        	roles.add(RoleServiceImpl.findByRolType(RolName.ROLE_USER).get());
        }
//        for (String rol : rolesStr) {
//            switch (rol) {
//                case "1":
//                	TypeRole rolAdmin = roleService.g(RolNombre.ROLE_ADMIN).get();
//                    roles.add(rolAdmin);
//                    break;
//                default:
//                	TypeRole rolUser = roleService.getByRolNombre(RolNombre.ROLE_USER).get();
//                    roles.add(rolUser);
//            }
//        }
        client.setId_type_role(roles);
        clientService.save(client);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody UserLogin loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos vacíos o documento inválido"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getDocument(), loginUsuario.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO, HttpStatus.OK);
    }
}
