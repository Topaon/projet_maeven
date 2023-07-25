package com.inetum.WebServiceRest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedQuery(name="allCompteWithMin", query="SELECT c FROM Compte c WHERE c.solde>?1")
@NamedQuery(name="allCompteWithMax", query="SELECT c FROM Compte c WHERE c.solde<?1")
@Getter @Setter @NoArgsConstructor
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numero;
	private String label;
	private Double solde;	
	
	// CONSTRUCTORS
	public Compte(Integer numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}
}
