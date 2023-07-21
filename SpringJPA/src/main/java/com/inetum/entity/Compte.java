package com.inetum.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="allCompteWithMin", query="SELECT c FROM Compte c WHERE c.solde>?1")
@NamedQuery(name="allCompteWithMax", query="SELECT c FROM Compte c WHERE c.solde<?1")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	private String label;
	private Double solde;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "compte", cascade = CascadeType.ALL) // si LAZY fonctionne pas mettre EAGER
	private List<Operation> operations;
	// Le mode LAZY renvoie uniquement le compte quand on l'appelle (performant)
	// le mode EAGER amene toutes ses opérations avec (lourd)
	
	@ManyToMany
	@JoinTable(name="compte_client", 
		joinColumns = {@JoinColumn(name="num_compte")},
		inverseJoinColumns = {@JoinColumn(name="num_client")})
	private List<Client> clients;
	
	
	
	// CONSTRUCTORS
	public Compte(Integer numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
		this.operations = new ArrayList<Operation>();
		this.clients = new ArrayList<Client>();
	}
	
	// GETTERS SETTERS
	public Compte() {
		super();
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClient(List<Client> clients) {
		this.clients = clients;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
	
}
