package com.inetum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
/**
 * Classe entitée qui mimique la BDD
 * @author Administrateur
 *
 */
@Entity
@NamedQuery(name="Employe.allWithSurname", query="SELECT e FROM Employe e WHERE e.prenom= ?1")
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	@Column(length=64)
	private String nom;
	private String prenom;
	private String email;
	
	
	// CONSTRUCTORS
	public Employe() {
		super();
	}
	
	public Employe(Integer numero, String nom, String prenom, String email) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	
	// GETTERS SETTERS
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.prenom = email;
	}
	// TO STRING
	@Override
	public String toString() {
		return "Employe [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
}