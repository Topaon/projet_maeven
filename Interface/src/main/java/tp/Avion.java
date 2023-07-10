package tp;

import java.util.ArrayList;

import tp.personne.Personne;

public class Avion {
	
	// ATTRIBUTS
	private String label;
	
		//Préparation des listes qui contiendront les bagages et les passagers de l'avion
	private ArrayList<Bagage> bagages = new ArrayList<Bagage>();
	private ArrayList<Personne> personnes = new ArrayList<Personne>();
	

	// CONSTRUCTEURS
	public Avion() {
		
	}

	public Avion(String label) {
		this.label = label;
	}
	
	// TOSTRING
	
	@Override
	public String toString() {
		return "Avion [label=" + label + "]";
	}
	
	// METHODES
	
		//Ajoute un bagage à l'avion
	public void addBagage(Bagage bagage) {
		bagages.add(bagage);
	}
	
		//Ajoute un passager à l'avion
	public void addPassenger(Personne passenger) {
		personnes.add(passenger);
	}

		//Calcul le poid total des bagages dans l'avion
	public double chargeUtile() {
		double somme_poids = 0.0;
		for(Bagage bag : this.bagages) {
			somme_poids = somme_poids + bag.poids;
		}
		return somme_poids;
	}
	
		//Fonction présentant l'avion
	public void afficher() {
		System.out.println("Avion numéro : " + this.label);
		System.out.println("Charge utile : " + this.chargeUtile());
		System.out.println("Bagages : ");
		for(Bagage bag : this.bagages) {
			System.out.println("\t" + bag.toString());
		}
		System.out.println("Passagers : ");
		for(Personne per : this.personnes) {
			System.out.println("\t" + per.toString());
		}
	}
	
	// GETTERS/SETTERS
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
