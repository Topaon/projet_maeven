package com.inetum.TpSpring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Operation;

@SpringBootTest
public class TestServiceCompte {

	Logger log = LoggerFactory.getLogger(TestServiceCompte.class);
	
	@Autowired
	private ServiceCompte serviceDaoCompte;
	
	
	public void testTransfert() {
		Compte cptA = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 1", null, 50.0)));
		Compte cptB = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 2", null, 100.0)));

		Compte cptAApres;
		Compte cptBApres;
		
		serviceDaoCompte.transferer(20d, cptB.getId(), cptA.getId(), "Remboursement voyage Angleterre");
		
		cptAApres = serviceDaoCompte.findCompteWithid(cptA.getId());
		cptBApres = serviceDaoCompte.findCompteWithid(cptB.getId());
		
		assertEquals(cptAApres.getSolde(), 70.0);
		assertEquals(cptBApres.getSolde(), 80.0);
		
		log.trace("Solde du compte A avant transfert : " + cptA.getSolde() + " et après : " + cptAApres.getSolde());
		log.trace("Solde du compte B avant transfert : " + cptB.getSolde() + " et après : " + cptBApres.getSolde());
		
	}
	
	
	public void testMauvaisTransfert() {
		Compte cptA = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 1", null, 50.0)));
		Compte cptB = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 2", null, 100.0)));
		
		try {
			serviceDaoCompte.transferer(20d, cptB.getId(), -2l, "Remboursement voyage Angleterre"); // Transfert depuis un compte qui n'existe pas
		} catch (Exception e) {
			// Exception normale en cas d'erreur
			log.trace("Le compte n'existe pas c'est le but du test : " + e.getMessage());
		}
		
		Compte cptAApres = serviceDaoCompte.findCompteWithid(cptA.getId());
		Compte cptBApres = serviceDaoCompte.findCompteWithid(cptB.getId());
		
		log.trace("Solde du compte A avant transfert : " + cptA.getSolde() + " et après : " + cptAApres.getSolde());
		log.trace("Solde du compte B avant transfert : " + cptB.getSolde() + " et après : " + cptBApres.getSolde());
		
		assertEquals(cptA.getSolde(), cptAApres.getSolde());
		assertEquals(cptB.getSolde(), cptBApres.getSolde());	
	}
	
	@Test
	public void testOperations() {
		Compte cptC = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 3", null, 100.0)));
		Compte cptD = serviceDaoCompte.sauvegarderCompte((new Compte(null, "Compte 4", null, 100.0)));
		
		serviceDaoCompte.transferer(20d, cptC.getId(), cptD.getId(), "Jap mardi soir");
		serviceDaoCompte.transferer(10d, cptC.getId(), cptD.getId(), "Macdo");
		serviceDaoCompte.transferer(15d, cptD.getId(), cptC.getId(), "Soirée RE4");
		
		for(Operation o:serviceDaoCompte.findCompteWithOperations(cptC.getId()).getOperations()) {
			log.trace(o.toString());
		}
	}
}