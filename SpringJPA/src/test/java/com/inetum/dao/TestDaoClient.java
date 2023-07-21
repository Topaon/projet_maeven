package com.inetum.dao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.entity.Client;
import com.inetum.entity.Compte;

@SpringBootTest
public class TestDaoClient {
	Logger logger = LoggerFactory.getLogger(Client.class);
	
	@Autowired
	private DaoClient daoClient;
	
	@Autowired
	private DaoCompte daoCompte;
	
	@Test
	public void testClientEtComptes() {
		Compte c1 = new Compte(null, "Compte partagé", 100.0);
		daoCompte.addCompte(c1);
		Compte c2 = new Compte(null, "Compte solo", 50.0);
		daoCompte.addCompte(c2);
		
		Client clA = daoClient.addClient(new Client(null, "Simon", "GRANIER"));
		Client clB = daoClient.addClient(new Client(null, "Madame", "GRANIER"));
		
		c1.getClients().add(clA);
		c1.getClients().add(clB);
		clA.getComptes().add(c1);
		clB.getComptes().add(c1);
		
		daoCompte.updateCompte(c1);
		daoClient.updateClient(clA);
		daoClient.updateClient(clB);
	}
}