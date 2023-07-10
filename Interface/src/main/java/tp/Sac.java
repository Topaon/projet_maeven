package tp;

public class Sac extends Bagage {
	double volume;
	
	// Constructeurs
	public Sac() {
		super();
	}
	
	public Sac(String label, double poids) {
		this.label = label;
		this.poids = poids;
	}

	public Sac(String label, String couleur, double poids, double volume) {
		super(label, couleur, poids);
		this.volume = volume;
	}
	
	// toString
	@Override
	public String toString() {
		return super.toString() + " [Volume : " + this.getVolume() + "]";
	}
	
	
	// Getter/Setter
	@Override
	public double getVolume() {
		return this.volume;
	}
	
	public void setVolume(double volume) {
		this.volume = volume;
	}
		
}
