package crud;

public class Stagiaire {
	int id;
	String prenom;
	String email;
	String mdp;
	String ddn;
	
	
	// CONSTRUCTEURS
	public Stagiaire(int id, String prenom, String mdp, String email, String ddn) {
		this.id = id;
		this.prenom = prenom;
		this.email = email;
		this.ddn = ddn;
		this.mdp = mdp;
	}
	
	// GETTER SETTER
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
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDdn() {
		return ddn;
	}
	public void setDdn(String ddn) {
		this.ddn = ddn;
	}
	
	// TOSTRING()
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", prenom=" + prenom + ", email=" + email + ", ddn=" + ddn + "]";
	}
}
