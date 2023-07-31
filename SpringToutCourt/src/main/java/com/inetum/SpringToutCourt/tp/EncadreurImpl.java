package com.inetum.SpringToutCourt.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncadreurImpl implements IEncadreur {

	public EncadreurImpl() {
		System.out.println("Constructeur d'EncadreurImpl");
	}

	@Autowired
	// Fait pointer la référence vers un objet spring chargé en mémoire avec le même type
	// S'exécute après le constructeur, donc attention aux pointeur null exception si un
	// constructeur veut utiliser une dépendance gérée par autowired
	private IPrefixeur prefixeur;
	
	@Autowired
	private ISuffixeur suffixeur;
	
	@PostConstruct
	public void initialisation() {
		System.out.println("Initialisation");
	}
	
	@Override
	public String encadrer(String c) {
		System.out.println("V1");
		return suffixeur.suffixer(prefixeur.prefixer(c));
	}

	@Override
	public String encadrerMaj(String c) {
		return suffixeur.suffixer(prefixeur.prefixer(c.toUpperCase()));
	}
}
