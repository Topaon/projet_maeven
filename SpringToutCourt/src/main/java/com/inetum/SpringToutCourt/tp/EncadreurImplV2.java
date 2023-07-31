package com.inetum.SpringToutCourt.tp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncadreurImplV2 implements IEncadreur {

	private IPrefixeur prefixeur;
	
	private ISuffixeur suffixeur;

	public EncadreurImplV2() {
		// constructeur par défaut avec 0 paramètres
	}
	
	@Autowired
	public EncadreurImplV2(IPrefixeur p, ISuffixeur s) {
		this.prefixeur = p;
		this.suffixeur = s;
	}
	
	@PostConstruct
	public void initialisation() {
		System.out.println("Initialisation");
	}
	
	@Override
	public String encadrer(String c) {
		System.out.println("V2");
		return suffixeur.suffixer(prefixeur.prefixer(c));
	}

	@Override
	public String encadrerMaj(String c) {
		return suffixeur.suffixer(prefixeur.prefixer(c.toUpperCase()));
	}
}
