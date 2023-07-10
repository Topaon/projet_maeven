package tp;

public class Valise extends Bagage {
	double hauteur;
	double largeur;
	double profondeur;
	
	// Constructeurs
	public Valise() {
		super();
	}
	
	public Valise(String label, double poids) {
		this.label = label;
		this.poids = poids;
	}
	
	public Valise(String label, String couleur, double poids, double hauteur, double largeur, double profondeur) {
		super(label, couleur, poids);
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.profondeur = profondeur;
	}
	
	// toString
	public String toString() {
		return super.toString() + " [Volume : " + this.getVolume() + "]";
	}
	
	
	// Getter/Setter
	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getProfondeur() {
		return profondeur;
	}

	public void setProfondeur(double profondeur) {
		this.profondeur = profondeur;
	}
	
	// Surcharge de la fonction getVolume
	@Override
	public double getVolume() {
		return this.hauteur*this.largeur*this.profondeur / 1000;
	}
	
	
}
