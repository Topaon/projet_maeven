package tp_interface;

import java.util.Scanner;

public class AfficheurInteractifText extends AfficheurText implements AfficheurInteractif {

	public String ecrire(String question) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(question);
		return scanner.nextLine();
	}
}
