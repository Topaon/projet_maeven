package tp_erreurs;

public class Calcul {

	public double racine_carre(double x) throws MyException {
		if(x>=0) {
			return Math.sqrt(x);
		}
		else {
			throw new MyException("Racine carré seulement prévue pour un nombre positif ou nul");
		}
			
	}
	
	public int division(int a, int b) {
		return a/b;
	}

}
