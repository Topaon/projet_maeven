package sg.corporation.echo.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ComparateurSearch implements Comparator {

	@Override
	public int compare(Object searched, Object filter) {
		Collator collator = Collator.getInstance(Locale.FRENCH);
		collator.setStrength(Collator.PRIMARY);
		int score = 0;
		
		if(searched instanceof String && filter instanceof String) {
			String s1 = (String) searched;
			String s2 = (String) filter;
			
			int taille_max = 0;
			
			if(s1.length() > s2.length()) {
				taille_max = s2.length();
			} else {
				taille_max = s1.length();
			}
			
			for(int x=0; x < taille_max; x++) {
				if(collator.compare(String.valueOf(s1.charAt(x)), String.valueOf(s2.charAt(x))) == 0) {
					score+=2;
				}
				if(s2.indexOf(s1.charAt(x)) != -1) {
					score++;
				}
			}
		}
		return score;
	}
}