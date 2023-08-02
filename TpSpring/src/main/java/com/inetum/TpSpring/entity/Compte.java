package com.inetum.TpSpring.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name = "Compte.rechercherCompteParNumeroAvecOperations",
				query = "SELECT c FROM Compte c LEFT JOIN FETCH c.operations WHERE c.id= ?1")
public class Compte {
	
	@Transient // Demande à Spring de ne pas persister cet attribut
	public static Double decouvertAutorise = -500.0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private Double solde;
	
	@ManyToOne
	@JoinColumn(name = "Titulaire_du_compte")
	private Customer owner;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;
	
	public Compte(Long id, String label, Customer owner, Double solde) {
		super();
		this.id = id;
		this.label = label;
		this.owner = owner;
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", label=" + label + "operations : " + operations + "]";
	}
}