package com.techBank.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_offices")
public class Office implements Serializable {

	private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	private int id_office;
	
	private String officeName; 
	
	private String direction;

	public long getId_office() {
		return id_office;
	}

	public void setId_office(int id_office) {
		this.id_office = id_office;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}  
	
}


/*
 * public ResponseEntity<?> create(@RequestBody Producto producto){
 * if(StringUtils.isBlank(producto.getNombreProducto())) return new
 * ResponseEntity(new Mensaje("el nombre es obligatorio"),
 * HttpStatus.BAD_REQUEST); if((Integer)producto.getPrecio() == null ||
 * producto.getPrecio()==0) return new ResponseEntity(new
 * Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
 * if(productoService.existePorNombre(producto.getNombreProducto())) r
 */