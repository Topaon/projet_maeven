package com.inetum.WebServiceRest.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.WebServiceRest.entity.Compte;

@SpringBootTest
public class TestDaoCompte {
	Logger log = LoggerFactory.getLogger(TestDaoCompte.class);
	
	@Autowired
	InterfaceDaoCompte daoCompte;

	@Test
	public void testCompte() {
		Compte compte1 = daoCompte.save(new Compte(null, "Compte 1", 10.0));

		compte1.setSolde(5.0);
		daoCompte.save(compte1);

		daoCompte.save(new Compte(null, "Compte 2", 20.0));
		daoCompte.save(new Compte(null, "Compte 3", 30.0));
		
		List<Compte> comptes = daoCompte.findAll();
		assertEquals(comptes.size(), 3);
		
		daoCompte.deleteById(2L);
		List<Compte> comptesApresSuppression = daoCompte.findAll();
		assertEquals(comptesApresSuppression.size(), 2);		
	}
	
	@Test
	public void testCompteAvecOperation() {
		Compte compte1 = daoCompte.save(new Compte(null, "Compte 1", 10.0));

		compte1.setSolde(5.0);
		daoCompte.save(compte1);

		daoCompte.save(new Compte(null, "Compte 2", 20.0));
		daoCompte.save(new Compte(null, "Compte 3", 30.0));
		
		List<Compte> comptes = daoCompte.findAll();
		assertEquals(comptes.size(), 3);
	}
}