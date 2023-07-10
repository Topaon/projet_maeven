package tp.personne;

public class Employe extends Personne{
	private int salaire;
	
	

	public Employe() {
		super();
		this.salaire = 0;
	}

	public Employe(String prenom, String nom, int age, int salaire) {
		super(prenom, nom, age);
		this.salaire = salaire;
		
	}

	public int getSalaire() {
		return salaire;
	}

	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}
	
	public String toString() {
		return super.toString() + " et mon salaire est de " + this.salaire + "€";
	}
	
}
