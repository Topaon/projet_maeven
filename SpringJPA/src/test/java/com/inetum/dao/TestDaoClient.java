package com.inetum.dao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.entity.Client;
import com.inetum.entity.Employe;
import com.inetum.entity.Personne;

@SpringBootTest
public class TestDaoClient {
	Logger logger = LoggerFactory.getLogger(Client.class);
	
	@Autowired
	private DaoClient daoClient;
	
	@Autowired
	private DaoEmploye daoEmploye;
	
	@Autowired
	private DaoPersonne daoPersonne;
	
	@Test
	public void testClientEtComptes() {
		daoClient.addClient(new Client(null, "Simon", "GRANIER"));
		daoClient.addClient(new Client(null, "Madame", "GRANIER"));
		
		daoEmploye.insertEmploye(new Employe(null, "Roger", "COMPTA", "r@sfr.fr"));
		daoEmploye.insertEmploye(new Employe(null, "Martine", "RH", "s@sfr.fr"));
		
		for(Personne p : daoPersonne.findAll()) {
			logger.trace(p.toString());
		}
	}
}