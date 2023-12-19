package sg.corporation.base;

public class Declarer_Variable {

	public static void declarerString() {
		// L'instance de String est placée dans le pool, si un doublon est déclaré de cette manière la jvm renverra cette instance à la place
		String string1 = "texte";
		
		// L'instance est crée hors du pool
		String string2 = new String("texte");
		
		String string3 = "texte";
		
		System.out.println(string1==string2); // Renvoie false car string1 et string2 ne pointent pas vers le même objet (string2 est declaré hors du pool)
		System.out.println(string1==string3); // Renvoie true car string3 a été déclaré dans le pool avec la même valeur canonique
		
		// NOTA BENE
		// L'opérateur == compare l'adresse et non la valeur canonique. Pour cela utiliser la méthode equals() de l'objet String
		System.out.println(string1.equals(string2));
		// Similaire à la méthode compareTo() de l'objet String mais moins précis dans la distinction entre les deux objets
	}
	
	public static void declarerInteger() {
		// Plus léger en mémoire car valeur au lieu d'objet
		int un = 1;
		
		// Donne accès à toutes les méthode l'objet Integer
		Integer Un = 1;
	}
}