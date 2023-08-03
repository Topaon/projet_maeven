package com.inetum.TpSpring.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Customer;

@SpringBootTest
public class TestDaoCustomer {
	
	@Autowired
	DaoCustomer daoCustomer;
	
	@Autowired
	DaoCompte daoCompte;
	
	@Test
	public void testCustomer() {
		Customer cust1 = daoCustomer.save(new Customer(null, "Simon", "GRANIER", "123"));
		Customer cust2 = daoCustomer.save(new Customer(null, "Mathieu", "PROSIC", "456"));
		Customer cust3 = daoCustomer.save(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		daoCompte.save(new Compte(null, "Compte du customer 1", cust1, 0.0));
		daoCompte.save(new Compte(null, "Deuxième compte du customer 1", cust1, 0.0));
		daoCompte.save(new Compte(null, "Compte du customer 2", cust2, 0.0));
		daoCompte.save(new Compte(null, "Compte du customer 3", cust3, 0.0));
		
		List<Customer> allCust = daoCustomer.findAll();
		List<Compte> allCompt = daoCompte.findAll();
		
		Customer cust1Saved = daoCustomer.findById(cust1.getId()).orElse(null);
		System.out.println(cust1Saved.getComptes().size());
	}
}