package tp;

public class Adresse {
	// Attributs
	String rue;
	String ville;
	int numero;
	int code_postal;
	
	// Constructeurs
	public Adresse() {
		
	}
	
	public Adresse(String rue, String ville, int numero, int code_postal) {
			this.rue = rue;
			this.ville = ville;
			this.numero = numero;
			this.code_postal = code_postal;
		}
	
	// Getters
	public String getRue() {
		return this.rue;
	}
	
	public String getVille() {
		return this.rue;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getCodePostal() {
		return this.code_postal;
	}
	
	// Setters
	public void setRue(String rue) {
		this.rue = rue;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setCodePostal(int code_postal) {
		this.code_postal = code_postal;
	}
	
	public String toString() {
		return "Je vis dans la ville de " + this.ville + " " + this.code_postal + ", au " + this.numero + " rue de " + this.rue;
	}
}
