package com.inetum.SpringToutCourt.blague;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component // On peut choisir un id avec @Component("monId"), par défaut c'est le nom de la classe commençant par une minuscule
//@Profile("drole") // choix au démarrage avec System.setProperty("spring.profiles.active", "V1,eventuelProfilComplementaire");
@Qualifier("drole") // les deux sont créé, on choisi au @Autowired, dans la classe qui utilise ce composant Spring
public class GenerateurBlagueDrole implements GenerateurBlague {
	
	private List<String> recueil;
	
	public GenerateurBlagueDrole() {
		recueil = new ArrayList<String>();
		
		recueil.add("C'est deux saucisses dans un micro-onde. \nLa première dis à l'autre : - Tu trouves pas qu'il fait un peu chaud ? \nL'autre répond : - Aaaah une saucisse qui parle !!!");
		recueil.add("Deux bouts de viande rentre dans la forêt. Quelques heures plus tard, ils ressortent à trois. Pourquoi ? \nY en a un qui steak haché");
		recueil.add("Quelle mamie fait le plus peur aux voleur ? \nMamie Traillette");
		recueil.add("Comment faisaient les dinausores quand ils n'arrivaient pas à se décider ? \nUn tirageosaure");
		recueil.add("Que se passe-t-il quand deux poissons se fachent ? \nLe thon monte");
		recueil.add("Que dit une imprimante qui se noie ? \nJ'ai papier");
		recueil.add("Quelle princesse n'a jamais les lèvres gercées ? \nLabello bois dormant");
		recueil.add("Daniel Radcliffe a fait son premier one man show le mois dernier, mais ça ne s'est pas bien passé. \nPersonne Harry");
		recueil.add("Quel est le médecin qui nous fait tous craquer ? \nL'ostéo");
		recueil.add("Qu'est-ce qui est pire que le vent ? \nUn Vampire");
		recueil.add("Une théière et un cendrier se dispute devant un ascenseur. \nLa théière veut mon thé, le cendrier veut des cendres");
		recueil.add("Que fait un geek qui descend du métro ? \nIl libère de la RAM");
		recueil.add("Quel est l'animal le plus connecté ? \nLe porc USB");
		recueil.add("Napoléon n'a jamais acheté de maison, il avait déjà un Bonaparte");
		recueil.add("Que dit Frodon devant sa maison ? \nC'est là que j'hobbit");
		recueil.add("Où va Lionel Messi quand il se blesse ? \nA la pharmessi");
		recueil.add("Comment appelle-t-on un chat tout terrain ? \nUn cat cat");
	}
	
	@Override
	public String getBlague() {
		return "Blague drole : \n" + recueil.get((int) Math.floor(Math.random() * recueil.size()));
	}
}
