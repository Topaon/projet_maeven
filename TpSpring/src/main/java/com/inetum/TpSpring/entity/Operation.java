package com.inetum.TpSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libele;
	private String sens;
	private Double montant;
	
	@ManyToOne
	@JoinColumn(name = "Compte")
	private Compte compte;
	
	public Operation(Long id, String libele, String sens, Double montant, Compte compte) {
		super();
		this.id = id;
		this.libele = libele;
		this.sens = sens;
		this.montant = montant;
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", libele=" + libele + ", sens=" + sens + ", montant=" + montant + "]";
	}
}
