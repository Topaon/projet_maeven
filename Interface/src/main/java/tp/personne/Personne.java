package tp.personne;

import tp.Transportable;

public class Personne implements Transportable {
	private String prenom;
	private String nom;
	private int age;
	private int taille;
	public static int joie=2;
	private final int AGE_MAX = 150;
	private static int ageMajorite = 18;
	
	// Constructeur de la classe Personne
	public Personne() {
		
	}
	
	public Personne(String prenom, String nom, int age) {
		this.prenom = prenom;
		this.nom = nom;
		this.age = age;		
	}
	
	// Getters
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public static int getAgeMajorite() {
		return ageMajorite;
	}
	
	// Setters
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setAge(int age) {
		if(age >= 0 && age <= AGE_MAX) this.age = age;
	}
	
	public void setTaille(int taille) {
		if(taille <= 300) this.taille = taille;
	}
	
	public static void setAgeMajorite(int age) {
		ageMajorite = age;
	}
	
	// Fonction pour incrémenter l'age
	public void IncrementAge() {
		if(age == 0) this.age = 1;
		else this.age++;
	}
	
	// Tester si la personne est majeure ou non
	public boolean isMajor() {
		if(this.age < ageMajorite) return false;
		else return true;
	}
	
	// TOSTRING
	public String toString() {
		return "Je suis " + this.prenom + ", j'ai " + this.age + " ans";
	}
	
	private double POIDS_MOYEN = 70.0;
	private double VOLUME_MOYEN = 50.0;
	
	
	@Override
	public double getPoids() {
		return POIDS_MOYEN;
	}

	@Override
	public double getVolume() {
		return VOLUME_MOYEN;
	}
}
