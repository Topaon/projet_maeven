package com.inetum.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.entity.Employe;

@SpringBootTest
public class TestDaoEmploye {
	
	Logger logger = LoggerFactory.getLogger(TestDaoEmploye.class);
	
	@Autowired // référence la classe daoEmp annotée avec @Repository
	private InterfaceDaoEmploye daoEmp;

	@Test
	public void testQueries() {
		daoEmp.insertEmploye(new Employe(null,"Midorya","deku", "s@sfr.fr"));
		daoEmp.insertEmploye(new Employe(null,"Tenya","ingenium", "s@sfr.fr"));
		daoEmp.insertEmploye(new Employe(null,"Ochaco","uravity", "s@sfr.fr"));
		daoEmp.insertEmploye(new Employe(null,"Tsuyu","Froppy", "s@sfr.fr"));
		
		List<Employe> employes = daoEmp.findAll();
		for(Employe emp : employes) {
			logger.error(emp.toString());
			logger.warn(emp.toString());
			logger.info(emp.toString());
			logger.debug(emp.toString());
			logger.trace(emp.toString());
		}
		assertEquals(employes.size(), 4);
	}
}