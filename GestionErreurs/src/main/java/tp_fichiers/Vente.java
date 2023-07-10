package tp_fichiers;

public class Vente {
	
	private String domaine;
	private int mois;
	private long ca;
	
	
	// CONSTRUCTEURS
	public Vente() {
		
	}

	public Vente(String domaine, int mois, long ca) {
		this.domaine = domaine;
		this.mois = mois;
		this.ca = ca;
	}
	
	// TOSTRING	
	@Override
	public String toString() {
		return "Vente [domaine=" + domaine + ", mois=" + mois + ", ca=" + ca + "]";
	}
	
	

	// GETTER/SETTER
	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public long getCa() {
		return ca;
	}

	public void setCa(int ca) {
		this.ca = ca;
	}
	
}
