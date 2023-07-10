package tp;

public interface Transportable {
	
	// Aucune méthode ne contient d'instruction, elles seront définies à chaque implémentation
	public double getPoids();
	public double getVolume();
	
	public static final String UNITE_POIDS = "kg";
	public static final String UNITE_VOLUME = "litre";
}