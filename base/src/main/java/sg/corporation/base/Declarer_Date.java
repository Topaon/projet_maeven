package sg.corporation.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Declarer_Date {
	public static void declarerDate() {
		// Date - le format de base des dates en Java
		Date date = new Date();
		System.out.println(date);
		
		// SimpleDateFormat - permet de choisir le format d'affichage
		SimpleDateFormat monFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(monFormat.format(new Date()));
		
		// Calendar - utile pour manipuler des dates (ajouter des jours, vérifier un mois, etc ...
		Calendar calendar = Calendar.getInstance();
		// Fixer une des caractéristiques - ici on fixe le mois (2) à août (7)
		// Voir classe Calendar pour savoir quelle numéro correspond à quelle champs (jour, mois, année...)
		calendar.set(2, 7);
		System.out.println(calendar.getTime());
		// Ajouter des mois (ici l'année est automatiquement maj, si on ne le souhaite pas méthode roll()
		calendar.add(2, 6);
		Date maDate = calendar.getTime();
		System.out.println(maDate);
		
		// Vérifier si le mois actuel est Juillet
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		if(cal.get(Calendar.MONTH) == Calendar.JULY) { // Une bonne manière d'avoir les indices quand on ne les connait pas par coeur
			System.out.println("Nous sommes en juillet");
		}
	}
}