package tp_interface;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class MyApp {

	public static void main(String[] args) {
		/*
		AfficheurInteractifText a = new AfficheurInteractifText();
		AfficheurInteractifDialog b = new AfficheurInteractifDialog();
		
		String prenom1 = a.ecrire("Quel est votre prenom ?");
		a.affiche("Vous vous appellez " + prenom1);
		
		b.affiche("Quel est votre prenom ?");
		String prenom2 = b.ecrire();
		b.affiche("Vous vous appellez " + prenom2);
		*/
		
		
		System.out.println("Bonjour");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine());
		
		JOptionPane.showMessageDialog(null, "Bonjour");
	}

}
