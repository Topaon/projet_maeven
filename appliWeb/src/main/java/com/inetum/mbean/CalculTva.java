package com.inetum.mbean;

@jakarta.faces.bean.ManagedBean // géré par Bean
@jakarta.faces.bean.RequestScoped // Données dans la Session
public class CalculTva {
	private Double ht;
	private Double taux = 0.2;
	private Double tva;
	private Double ttc;
	
	/**
	 * En fonction d'un montant HT et du taux de TVA, calcul le montant TTC et celui de la TVA
	 * @return
	 */
	public String calculTva() {
		String suite = null;
		this.ttc = ht * (1 + taux);
		this.tva = ttc - ht;
		return suite;
	}

	// GETTERS SETTERS
	public Double getHt() {
		return ht;
	}

	public void setHt(Double ht) {
		this.ht = ht;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public Double getTva() {
		return tva;
	}

	public void setTva(Double tva) {
		this.tva = tva;
	}

	public Double getTtc() {
		return ttc;
	}

	public void setTtc(Double ttc) {
		this.ttc = ttc;
	}	
}
