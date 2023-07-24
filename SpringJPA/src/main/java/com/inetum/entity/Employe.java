package com.inetum.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Employe")
public class Employe extends Personne {
	private String email;
	
	public Employe() {
		super();
	}
	public Employe(Integer numero, String nom, String prenom, String email) {
		super(numero, nom, prenom);
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}