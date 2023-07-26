package com.inetum.WebServiceRest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "Numero du compte", example = "5")
	private Integer numero;
	private String label;
	private Double solde;
	
	@JsonIgnore // pour demander à ignorer la liste des opérations 
				// quand l'objet courant de la classe compte sera 
				// automatiquement convertit de JAVA en JSON
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compte" , cascade = CascadeType.ALL)
	private List<Operation> operations;
	
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
