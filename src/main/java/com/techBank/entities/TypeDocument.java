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
 
import com.techBank.security.enums.DocumentName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="t_type_documents")
@ApiModel(description="Documents Model")
public class TypeDocument implements Serializable {

	private static final long serialVersionUID = 561837640739567975L; 
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@ApiModelProperty(notes="ID_TYPE_DOCUMENT on the Bank", name="id_type_document", required=true, value="2") 
	private int id_type_document;
	
	@NotNull
	@Enumerated(EnumType.STRING) 
	@ApiModelProperty(notes="DOCUMENTTYPE on the Bank", name="documentType", required=true, value="CC") 
	private DocumentName documentType;  
	
	public TypeDocument() {}

    public TypeDocument(@NotNull DocumentName documentType) {
        this.documentType = documentType;
    }

	public int getId_type_document() {
		return id_type_document;
	}

	public void setId_type_document(int id_type_document) {
		this.id_type_document = id_type_document;
	}

	public DocumentName getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentName documentType) {
		this.documentType = documentType;
	}
     
	   
}
 