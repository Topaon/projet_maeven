package com.inetum.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Client.getById", 
query="SELECT c FROM Client c LEFT JOIN FETCH c.comptes WHERE c.id = ?1")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String prenom;
	private String nom;

	@ManyToMany(mappedBy = "clients")
	private List<Compte> comptes;

	
	// CONSTRUCTORS
	public Client() {
		super();
	}

	public Client(Integer id, String prenom, String nom) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.comptes = new ArrayList<Compte>();
	}

	// GETTERS SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	
}
