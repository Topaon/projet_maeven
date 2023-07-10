package tp.entity;

public class Personne {
	public enum Nationalite {FRANCAIS, ANGLAIS, ALLEMAND, ESPAGNOL, SUEDOIS, ITALIEN};
	
	Integer id;
	String nom;
	String prenom;
	private Nationalite nationalite = Nationalite.FRANCAIS;
	
	
	// CONSTRUCTEUR
	public Personne() {
		this.nationalite = Nationalite.FRANCAIS;
	}
	
	public Personne(Integer id, String prenom, String nom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	// TOSTRING
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	// GETTER/SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Nationalite getNationalite() {
		return nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
	}
	
	
	
	
	
	

}
