package sg.corporation.base;

import java.text.Collator;
import java.util.Comparator;

public class Comparer_String {

	public static void comparerString() {
		String txt = "frais";
		String txt2 = "pas frais";
		
		// 1 - opérateur d'égalité d'adresse
		System.out.println(txt==txt2);
		
		// 2 - méthode compareTo(texteacomparer) de l'objet String
		System.out.println(txt.compareTo(txt2));
		
		// 3 - comparator
		class MonComparateur implements Comparator<String> {

			@Override
			public int compare(String o1, String o2) {
				if(o1 == o2) {
					return 0;
				} else {
					return -1;
				}
			}
		}
		MonComparateur monComparateur = new MonComparateur();
		System.out.println(monComparateur.compare(txt, txt2));
		
		// 4 - collator
		Collator collator = Collator.getInstance();
		collator.setStrength(Collator.PRIMARY);
		System.out.println(collator.compare(txt, txt2));
	}
}