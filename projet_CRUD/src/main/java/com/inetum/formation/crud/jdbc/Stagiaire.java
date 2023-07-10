package com.inetum.formation.crud.jdbc;

import java.sql.Date;

public class Stagiaire {
	private int id;
	private String prenom;
	private String email;
	private Date date_naissance;
	private String mdp;
	
	// Constructeurs	
	public Stagiaire(int id, String prenom, String email, Date date_naissance, String mdp) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.date_naissance = date_naissance;
		this.mdp = mdp;
	}
	
	public Stagiaire() {
		
	}


	// GETTERS/SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	// toString()
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", prenom=" + prenom + ", email=" + email + ", date_naissance=" + date_naissance
				+ "]";
	}
	
}
