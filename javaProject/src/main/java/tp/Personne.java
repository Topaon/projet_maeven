package tp;

public class Personne {
	private String prenom;
	private String nom;
	private int age;
	
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
	
	// Setters
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	// Fonction test
	public String test() {
		return "un, deux, trois";
	}
	
	public String test(String deux) {
		return "un, " + deux + ", trois";
	}
}
