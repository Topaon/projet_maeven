package com.inetum.SpringToutCourt.tp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Note : @Lazy pour ne charger un composant spring que lorsqu'on l'utilise,
// 		  par défaut il le sont dès le démarrage
@Component("idDeMonComposant")
// Permet la prise en charge par Spring. Par défaut l' id est le nom de la classe commencant par une minuscule
@Scope("singleton")
// Présent par défaut, les composants Spring sont créés en un seul exemplaire
public class PrefixeurV1 implements IPrefixeur {

	private String prefixe="**";
	
	@Override
	public String prefixer(String c) {
		// TODO Auto-generated method stub
		return prefixe+c;
	}

	@Override
	public String prefixerMaj(String c) {
		// TODO Auto-generated method stub
		return prefixe+c.toUpperCase();
	}
}