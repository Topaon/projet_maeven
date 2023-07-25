package com.inetum.WebServiceRest.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inetum.WebServiceRest.dao.DaoCompte;
import com.inetum.WebServiceRest.entity.Compte;

@Component
public class InitData {
	
	@Autowired
	DaoCompte daoCompte;
	
	@PostConstruct
	public void initData() {
		daoCompte.addCompte(new Compte(null, "Compte 1", 10.0));
		daoCompte.addCompte(new Compte(null, "Compte 2", 20.0));
		daoCompte.addCompte(new Compte(null, "Compte 3", 278.0));
		daoCompte.addCompte(new Compte(null, "Compte 4", 9.0));
		daoCompte.addCompte(new Compte(null, "Compte 5", 504.0));
		daoCompte.addCompte(new Compte(null, "Compte 6", 58.0));
		daoCompte.addCompte(new Compte(null, "Compte 7", 657.0));
		daoCompte.addCompte(new Compte(null, "Compte 8", 7.0));
		daoCompte.addCompte(new Compte(null, "Compte 9", 913.0));
		daoCompte.addCompte(new Compte(null, "Compte 10", 73.0));
	}
}
