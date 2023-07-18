package com.inetum.data;

public class Produit {
	private String ref;
	private String label;
	private Double prix;
	private String cat;
	
	
	// Constructeurs
	public Produit() {
		
	}
	
	public Produit(String ref, String label, Double prix, String cat) {
		this.ref = ref;
		this.label = label;
		this.prix = prix;
		this.cat = cat;
	}
	
	// GETTERS SETTERS
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	
	
}
