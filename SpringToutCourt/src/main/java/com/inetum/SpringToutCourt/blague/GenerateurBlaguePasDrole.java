package com.inetum.SpringToutCourt.blague;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("pasDrole")
@Qualifier("pasDrole")
public class GenerateurBlaguePasDrole implements GenerateurBlague {

	private List<String> recueil;

	public GenerateurBlaguePasDrole() {
		recueil = new ArrayList<String>();

		recueil.add("C'est l'histoire d'un zoophile qui rentre dans un bar");
		recueil.add("Quel est le comble pour un marteau ? D'en avoir marre tôt");
		recueil.add("Comment attraper les poissons facilement ? Avec une canne à pêche");
	}
	
	@Override
	public String getBlague() {
		return "Blague pas drole : \n" + recueil.get((int) Math.floor(Math.random() * recueil.size()));
	}
	
}
