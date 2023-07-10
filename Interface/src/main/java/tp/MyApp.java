package tp;

import tp.personne.Personne;

public class MyApp {

	public static void main(String[] args) {		
		Avion airbus = new Avion("AF714");
		airbus.addBagage(new Sac("sakado", 45));
		airbus.addBagage(new Valise("vladise", 20));
		airbus.addBagage(new Valise("v1", 13));
		airbus.addBagage(new Valise("v2", 6));
		airbus.addBagage(new Sac("s1", 31));
		airbus.addBagage(new Sac("s2", 12));
		
		airbus.addPassenger(new Personne("Simon", "Granier", 25));
		airbus.addPassenger(new Personne("Judith", "Granier", 23));
		airbus.addPassenger(new Personne("Lucie", "Granier", 21));
		airbus.addPassenger(new Personne("Sarah", "Granier", 18));
		
		airbus.afficher();
		
		
	}
}