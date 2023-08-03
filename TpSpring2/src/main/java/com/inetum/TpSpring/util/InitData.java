package com.inetum.TpSpring.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.TpSpring.dao.DaoCompte;
import com.inetum.TpSpring.dao.DaoCustomer;
import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Customer;

@Component
@Profile("init")
public class InitData {
	
	@Autowired
	DaoCustomer daoCustomer;
	
	@Autowired
	DaoCompte daoCompte;
	
	@PostConstruct
	public void InitialisationData() {
		Customer cust1 = daoCustomer.save(new Customer(null, "Simon", "GRANIER", "123"));
		Customer cust2 = daoCustomer.save(new Customer(null, "Mathieu", "PROSIC", "456"));
		Customer cust3 = daoCustomer.save(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		daoCompte.save(new Compte(null, "Compte du customer 1", cust1, 0.0));
		daoCompte.save(new Compte(null, "Deuxième compte du customer 1", cust1, 0.0));
		daoCompte.save(new Compte(null, "Compte du customer 2", cust2, 0.0));
		daoCompte.save(new Compte(null, "Compte du customer 3", cust3, 0.0));
	}
}