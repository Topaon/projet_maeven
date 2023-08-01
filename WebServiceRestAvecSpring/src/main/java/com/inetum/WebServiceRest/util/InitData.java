package com.inetum.WebServiceRest.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.WebServiceRest.dao.InterfaceDaoCompte;
import com.inetum.WebServiceRest.entity.Compte;

@Component
@Profile("initData")
public class InitData {
	
	@Autowired
	InterfaceDaoCompte daoCompte;
	
	@PostConstruct
	public void initData() {
		daoCompte.save(new Compte(null, "Albert", 10d));
		daoCompte.save(new Compte(null, "Babar", 20.0));
		daoCompte.save(new Compte(null, "Compte 3", 278.0));
		daoCompte.save(new Compte(null, "Compte 4", 9.0));
		daoCompte.save(new Compte(null, "Compte 5", 504.0));
		daoCompte.save(new Compte(null, "Arnaud", 58.0));
		daoCompte.save(new Compte(null, "Compte 7", 657.0));
		daoCompte.save(new Compte(null, "Compte 8", 7.0));
		daoCompte.save(new Compte(null, "Compte 9", 913d));
		daoCompte.save(new Compte(null, "Compte 10", 73.0));
	}
}
