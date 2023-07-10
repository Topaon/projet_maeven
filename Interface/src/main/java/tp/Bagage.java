package tp;

public abstract class Bagage implements Transportable {
	String label;
	String couleur;
	double poids;
	
	// Constructeur
	public Bagage() {
		this.label = "";
	}
	
	public Bagage(String label, double poids) {
		this.label = label;
		this.poids = poids;
	}
	
	public Bagage(String label, String couleur, double poids) {
		this.label = label;
		this.couleur = couleur;
		this.poids = poids;
	}
	
	// toString
	
	public String toString() {
		return this.label;
	}
	
	// Calcul du volume, à polymorpher depuis les sous-classes
	public abstract double getVolume();
	
	
	// Getters et Setters
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	
	
}
