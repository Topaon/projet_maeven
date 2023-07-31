package com.inetum.SpringToutCourt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.inetum.SpringToutCourt.blague.PresentateurBlague;

public class SpringToutCourtApplication {

	public static void main(String[] args) {
		testCartes(7);
	}
	
	public static void testSpring() {
		System.out.println("Démarrage appli Spring");
		AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(MySpringConfig.class);
		// Créé toutes les instances des composants Spring nécessaires
		
		PresentateurBlague pb = springContext.getBean(PresentateurBlague.class);
		// IPrefixeur prefixeur = (IPrefixeur) springContext.getBean("idDeMonComposant");
		// La méthode .getBean() permet d'obtenir la référence d'un composant Spring, via son id (nécessite un cast) ou sa classe
		
		System.out.println("Appli Spring démarrée");
		System.out.println(pb.presenterBlague());
		// Grace à Spring, toutes les instances des classes nécessaires sont déjà créées 
		// et référenciées entre elles (ce qu'on appelle l'auto-injection)
	}
	
	public static void testRnd() {
		int zero = 0;
		int un = 0;
		int deux = 0;
		int trois = 0;
		for(int i=0; i<10000000; i++) {
			int nb = (int) Math.floor(Math.random() * 4);
			if(nb == 0) {
				zero += 1;
			} else if(nb == 1) {
				un += 1;
			} else if(nb == 2) {
				deux += 1;
			} else {
				trois += 1;
			}
		}
		System.out.println(zero);
		System.out.println(un);
		System.out.println(deux);
		System.out.println(trois);
	}
	
	public static void testCartes(int nbCartesRecherche) {
		int carteEnMain = 0;
		int compte = 0;
		
		for(int c = 0; c<1000000; c++) {
			List<Integer> deck = new ArrayList<>();
			List<Integer> main = new ArrayList<>();
			for(int i = 0; i<40; i++) {
				deck.add(i+1);
			}
			for(int i = 0; i<5; i++) {
				int nb = (int) Math.floor(Math.random() * (40-main.size()));
				main.add(deck.get(nb));
				deck.remove(nb);
			}
			for(int i:main) {
				if(i >= 1 && i <= nbCartesRecherche) {
					carteEnMain = 1;
				}
			}
			if(carteEnMain == 1) {
				compte += 1;
			}
			carteEnMain = 0;
		}
		double res = (compte/10000);
		System.out.println(res + "%");
	}
}