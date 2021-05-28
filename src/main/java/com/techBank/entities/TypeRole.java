package com.techBank.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import com.techBank.security.enums.RolName;

@Entity
@Table(name="t_type_roles")
@ApiModel(description="Roles Model")
public class TypeRole implements Serializable {

     
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
	@ApiModelProperty(notes="ID_TYPE_ROLE on the Bank", name="id_type_role", required=true, value="2") 
	private long id_type_role;

	@NotNull
	@Enumerated(EnumType.STRING) 
	@ApiModelProperty(notes="ROLTYPE on the Bank", name="rolType", required=true, value="Admin") 
    private RolName rolType;

    public TypeRole() {}

    public TypeRole(@NotNull RolName rolType) {
        this.rolType = rolType;
    }

	public long getId_type_role() {
		return id_type_role;
	}

	public void setId_type_role(long id_type_role) {
		this.id_type_role = id_type_role;
	}

	public RolName getRolType() {
		return rolType;
	}

	public void setRolType(RolName rolType) {
		this.rolType = rolType;
	}
     
    
}
 
