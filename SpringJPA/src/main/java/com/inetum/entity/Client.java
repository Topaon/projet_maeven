package com.inetum.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Client")
public class Client extends Personne {
	
	public Client() {
		super();
	}
	public Client(Integer numero, String nom, String prenom) {
		super(numero, nom, prenom);
	}	
}
