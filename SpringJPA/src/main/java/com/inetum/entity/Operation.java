package com.inetum.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idOp;
	private Double montant;
	private String label;
	
	@Temporal(TemporalType.DATE)
	private Date dateOp;
	
	@ManyToOne
	 @JoinColumn(name="num_compte")
	private Compte compte;

	
	// CONSTRUCTEURS
	public Operation() {
		super();
	}
	
	public Operation(Integer idOp, Double montant, String label, Date dateOp, Compte compte) {
		super();
		this.idOp = idOp;
		this.montant = montant;
		this.label = label;
		this.dateOp = dateOp;
		this.compte = compte;
	}

	public Operation(Integer idOp, Double montant, String label, Date dateOp) {
		super();
		this.idOp = idOp;
		this.montant = montant;
		this.label = label;
		this.dateOp = dateOp;
	}
	
	// GETTERS SETTERS
	public Integer getIdOp() {
		return idOp;
	}

	public void setIdOp(Integer idOp) {
		this.idOp = idOp;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDateOp() {
		return dateOp;
	}

	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return "Operation [idOp=" + idOp + ", montant=" + montant + ", label=" + label + ", dateOp=" + dateOp + "]";
	}
}
