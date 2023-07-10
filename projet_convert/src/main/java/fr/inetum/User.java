package fr.inetum;

public class User {
	String email;
	String mdp;

	public User(String email, String mdp) {
		this.email = email;
		this.mdp = mdp;
	}

	// Getters et Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
