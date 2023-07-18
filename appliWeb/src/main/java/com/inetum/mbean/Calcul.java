package com.inetum.mbean;

@jakarta.faces.bean.ManagedBean // géré par Bean
@jakarta.faces.bean.RequestScoped // Données dans la Session
public class Calcul {
	private Double x; // à saisir
	private Double res; // résultat de la racine carrée
	
	
	// SUITE DU TP page 34 du pdf
	public String calculerRacineCarre() { // pas de besoin de paramètres d'entrée
		String suite=null; // ou "page2" ou ..
		System.out.println("fonction calculerRacineCarre de la classe Calcul");
		this.res = Math.sqrt(x);  // code qui nous intéresse
		
		return suite; // si null on reste sur la même page
	}
	
	// GETTERS SETTERS
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getRes() {
		return res;
	}
	public void setRes(Double res) {
		this.res = res;
	}
}
