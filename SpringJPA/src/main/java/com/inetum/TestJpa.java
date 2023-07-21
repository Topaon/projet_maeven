package com.inetum;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.inetum.dao.DaoCompte;
import com.inetum.dao.DaoEmploye;
import com.inetum.entity.Compte;
import com.inetum.entity.Employe;

public class TestJpa {

	public static void main(String[] args) {
//		//NB: appliSpringJpa= name du persistent-unit configuré dans META-INF/persistence.xml
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appliSpringJpa");
//		EntityManager entityManager = emf.createEntityManager();
//		
//		testDaoEmploye(entityManager);
//		
//		entityManager.close();
//		emf.close();
		testDaoClient();
	}
	
	public static void testDaoEmploye(EntityManager entityManager) {
		DaoEmploye daoEmp = new DaoEmploye();
		
		Employe emp1 = new Employe(null,"Granier","simon", "s@sfr.fr");
		daoEmp.insertEmploye(emp1);
		Employe emp2 = new Employe(null,"Dupuis","adrien", "s@sfr.fr");
		daoEmp.insertEmploye(emp2);
		Employe emp3 = new Employe(null,"Prosic","simon", "s@sfr.fr");
		daoEmp.insertEmploye(emp3);
		Employe emp4 = new Employe(null,"Clement","antoine", "s@sfr.fr");
		daoEmp.insertEmploye(emp4);
		Employe emp5 = new Employe(null,"Trihn","adrien", "s@sfr.fr");
		daoEmp.insertEmploye(emp5);
		Employe emp6 = new Employe(null,"Lebrun","simon", "s@sfr.fr");
		daoEmp.insertEmploye(emp6);
		
		List<Employe> employes = daoEmp.findAll();
		for(Employe emp : employes) {
		System.err.println(emp);
		}
	}
	
	public static void testDaoCompte() {
		DaoCompte daoCom = new DaoCompte();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("appliSpringJpa");
		EntityManager entityManager = emf.createEntityManager();
		daoCom.setEntityManager(entityManager);
		
		Compte compte1 = new Compte(null,"Compte de Harry",4000.0);
		daoCom.addCompte(compte1);
		Compte compte2 = new Compte(null,"Compte de Georges",200.0);
		daoCom.addCompte(compte2);
		Compte compte3 = new Compte(null,"Compte de Fred",100.0);
		daoCom.addCompte(compte3);
		Compte compte4 = new Compte(null,"Compte de Ron",120.0);
		daoCom.addCompte(compte4);
		
		List<Compte> comptes = daoCom.findAll();
		for(Compte com : comptes) {
			System.err.println(com);
		}
	}
	
	public static void testDaoClient() {
//		DaoClient dc = new DaoClient();
//		Client c1 = new Client(null, "Simon", "GRANIER", new ArrayList<Compte>());
//		dc.addClient(c1);
	}
}
