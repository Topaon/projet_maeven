package com.inetum.WebServiceRest.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idOp;
	private Double montant;
	private String label;
	
	@Temporal(TemporalType.DATE)
	private Date dateOp;
	
	@ManyToOne //Many Operation To one Compte
	@JoinColumn(name = "num_compte")
	private Compte compte;
	
	// CONSTRUCTEURS
	
	public Operation(Integer idOp, Double montant, String label, Date dateOp, Compte compte) {
		super();
		this.idOp = idOp;
		this.montant = montant;
		this.label = label;
		this.dateOp = dateOp;
	}

	public Operation(Integer idOp, Double montant, String label, Date dateOp) {
		super();
		this.idOp = idOp;
		this.montant = montant;
		this.label = label;
		this.dateOp = dateOp;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Operation [idOp=" + idOp + ", montant=" + montant + ", label=" + label + ", dateOp=" + dateOp + "]";
	}
}
