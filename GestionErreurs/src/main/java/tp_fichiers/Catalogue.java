package tp_fichiers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Catalogue {
	
	public static List<Vente> listeVentes = new ArrayList<>();
	
	public static BufferedReader ouvrirFichier() {
	// Ouvre un fichier dans un objet BufferedReader pour l'utiliser dans d'autres fonctions
		
		// Origine du fichier vente
		String src = "ventes.csv";
		
		// Lecture des bytes du fichier
		FileInputStream fis = null;
		try { fis = new FileInputStream(src);} 
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		// Traduction des bytes en String
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		return br;
	}
	
	
	
	public static void completerListeVentes() {
	// Fonction pour compléter la variable listeVentes
		
		BufferedReader br = ouvrirFichier();
		
		// Lecture de la ligne
		try {
			String ligne = br.readLine();
			ligne = br.readLine();
			while (ligne != null) {
				String[] t = ligne.split(";");
				Vente v = new Vente(t[0], Integer.parseInt(t[1]), Long.parseLong(t[2]));
				listeVentes.add(v);
				ligne = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Il y a eu un problème");
		}
	}
	
	public static void afficherFichierVentesV1() {
	// Fonction pour afficher le fichier des ventes
	// Ancienne version sans lambda expression
		
		completerListeVentes();
		ComparateurDeVente c = new ComparateurDeVente();
		Collections.sort(listeVentes, c);
		
		for(Vente a : listeVentes) {
			System.out.println(a.toString());
		}
	}
	
	public static void afficherFichierVentesV2() {
	// Fonction pour afficher le fichier des ventes
	// Version avec les stream
		
		completerListeVentes();
		
		Collections.sort(listeVentes, (v1, v2) -> (int) (v1.getCa() - v2.getCa()));
		
		for(Vente a : listeVentes) {
			System.out.println(a.toString());
		}
	}
	
	public static void afficherFichierVentes() {
	// Fonction pour afficher le fichier des ventes
	// Version avec lambda expression
		
		completerListeVentes();
		
		listeVentes.stream()
			.sorted((v1, v2) -> (int) (v1.getCa() - v2.getCa()))
			.forEach((p) -> System.out.println(p));
		
		listeVentes.stream()
			.sorted((v1, v2) -> (int) (v1.getCa() - v2.getCa()))
			.collect(Collectors.toList());
		
	}
	
	public static void afficherFichierVentes(String domaine) {
		// Variante pour n'afficher que les ventes liées au domaine en paramètre
			
			completerListeVentes();
			
			listeVentes.stream()
				.sorted((v1, v2) -> (int) (v1.getCa() - v2.getCa()))
				.filter((v) -> v.getDomaine().equals(domaine))
				.forEach((p) -> System.out.println(p));
			
		}
	
	
	
	public static void ecrireFichierStats() {
	// Fonction pour générer le fichier contenant les stats des ventes
		
			try (FileOutputStream file = new FileOutputStream("stats.txt")) {
				PrintStream ps = new PrintStream(file);
				ps.println("domaine;ca_total");
				
				// Récupérer les données du fichier ventes.csv
				BufferedReader br = ouvrirFichier();
				
				
				double a_inserer = 0.0;
				String line = br.readLine();
				line = br.readLine();
				
				while(line != null) {
					String[] t = line.split(";");
					a_inserer += Double.parseDouble(t[2]);
					line = br.readLine();
				}
				
				ps.println("all;" + String.valueOf(a_inserer));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}	
}
