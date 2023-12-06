package sg.corporation.echo.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class ComparateurStyle implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Collator collator = Collator.getInstance(Locale.FRENCH);
		collator.setStrength(Collator.PRIMARY);
		
		if(o1 instanceof String && o2 instanceof String) {
			String s1 = (String) o1;
			String s2 = (String) o2;
			
			return collator.compare(s1, s2);
		}
		return 0;
	}
}