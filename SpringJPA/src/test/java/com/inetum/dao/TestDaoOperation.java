package com.inetum.dao;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.entity.Compte;
import com.inetum.entity.Operation;

@SpringBootTest
public class TestDaoOperation {
	Logger logger = LoggerFactory.getLogger(Operation.class);
	
	@Autowired
	private DaoOperation daoOperation;
	
	@Autowired
	private DaoCompte daoCompte;
	
//	@Test
//	public void testDaoOperation() {
//		daoCompte.addCompte(new Compte(null,"Compte de Harry",4000.0));
//		daoCompte.addCompte(new Compte(null,"Compte de Georges",200.0));
//		daoCompte.addCompte(new Compte(null,"Compte de Fred",100.0));
//		daoCompte.addCompte(new Compte(null,"Compte de Ron",120.0));
//		
//		List<Compte> comptes = daoCompte.findAll();
//		
//		for(Compte c:comptes) {
//			logger.trace(c.toString());
//		}
//	}
	
	@Test
	public void testSensSecondaire() {
//		// ne marche pas
//		Compte c1 = new Compte(null,"Compte de Harry",4000.0);
//		c1.getOperations().add(new Operation(null, -2.0, "Achat stylo", new Date()));
//		c1.getOperations().add(new Operation(null, -3.4, "Achat gomme", new Date()));
//		daoCompte.updateCompte(c1); // Sauvegarde demandée du côté mappedBy, ça ne fonctionne pas
		
		// à la place il faut faire ça :
		Compte c1 = daoCompte.addCompte(new Compte(null,"Compte de Harry",4000.0));
		
		Operation op1 = new Operation(null, -2.0, "Achat stylo", new Date());
		op1.setCompte(c1);
		daoOperation.addOperation(op1);
		
		Operation op2 = new Operation(null, -3.4, "Achat gomme", new Date());
		op2.setCompte(c1);
		daoOperation.addOperation(op2);
		// Quand on créé l'adresse en base on doit pouvoir la ratacher à un compte existant
	}
}