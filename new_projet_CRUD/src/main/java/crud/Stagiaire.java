package crud;

import util.Util;

public class Stagiaire {
	int id;
	String prenom;
	String email;
	String mdp;
	String ddn;
	String photo;
	
	
	// CONSTRUCTEURS
	public Stagiaire(int id, String prenom, String mdp, String email, String ddn) {
		this.id = id;
		this.prenom = Util.capitalize(prenom);
		this.email = email;
		this.ddn = ddn;
		this.mdp = mdp;
		this.photo = this.prenom + ".png";
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	// TOSTRING()
	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", prenom=" + prenom + ", mdp = " + mdp + ", email=" + email + ", ddn=" + ddn + "]";
	}
}
