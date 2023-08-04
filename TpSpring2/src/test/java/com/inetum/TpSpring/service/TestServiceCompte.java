package com.inetum.TpSpring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Operation;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceCompte {

	Logger log = LoggerFactory.getLogger(TestServiceCompte.class);
	
	@Autowired
	private ServiceCompte serviceCompte;
	
	@Test
	public void testTransfert() {
		Compte cptA = serviceCompte.saveOrUpdate((new Compte(null, "Compte 1", null, 50.0)));
		Compte cptB = serviceCompte.saveOrUpdate((new Compte(null, "Compte 2", null, 100.0)));

		Compte cptAApres;
		Compte cptBApres;
		
		serviceCompte.transferer(20d, cptB.getId(), cptA.getId(), "Remboursement voyage Angleterre");
		
		cptAApres = serviceCompte.searchById(cptA.getId());
		cptBApres = serviceCompte.searchById(cptB.getId());
		
		assertEquals(cptAApres.getSolde(), 70.0);
		assertEquals(cptBApres.getSolde(), 80.0);
		
	}
	
	// @Test // marche mais génère des erreurs (voulues) qui polluent le log
	public void testMauvaisTransfert() {
		Compte cptA = serviceCompte.saveOrUpdate((new Compte(null, "Compte 1", null, 50.0)));
		Compte cptB = serviceCompte.saveOrUpdate((new Compte(null, "Compte 2", null, 100.0)));
		
		try {
			serviceCompte.transferer(20d, cptB.getId(), -2l, "Remboursement voyage Angleterre"); // Transfert depuis un compte qui n'existe pas
		} catch (Exception e) {
			// Exception normale en cas d'erreur
//			log.trace("Le compte n'existe pas c'est le but du test : " + e.getMessage());
		}
		
		Compte cptAApres = serviceCompte.searchById(cptA.getId());
		Compte cptBApres = serviceCompte.searchById(cptB.getId());
		
		assertEquals(cptA.getSolde(), cptAApres.getSolde());
		assertEquals(cptB.getSolde(), cptBApres.getSolde());	
	}
	
	@Test
	public void testOperations() {
		Compte cptC = serviceCompte.saveOrUpdate((new Compte(null, "Compte 3", null, 100.0)));
		Compte cptD = serviceCompte.saveOrUpdate((new Compte(null, "Compte 4", null, 100.0)));
		
		serviceCompte.transferer(20d, cptC.getId(), cptD.getId(), "Jap mardi soir");
		serviceCompte.transferer(10d, cptC.getId(), cptD.getId(), "Macdo");
		serviceCompte.transferer(15d, cptD.getId(), cptC.getId(), "Soirée RE4");
		
		for(Operation o:serviceCompte.findCompteWithOperations(cptC.getId()).getOperations()) {
			log.trace(o.toString());
		}
	}
	
	@Test
	public void testTousLesComptes() {
		Compte cptC = serviceCompte.saveOrUpdate((new Compte(null, "Compte 3", null, 100.0)));
		Compte cptD = serviceCompte.saveOrUpdate((new Compte(null, "Compte 4", null, 100.0)));
		for(Compte c : serviceCompte.searchAll()) {
			log.trace(c.toString());
		}
	}
}