package com.inetum.TpSpring.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.TpSpring.dao.DaoCustomer;
import com.inetum.TpSpring.entity.Customer;

@Component
@Profile("init")
public class InitData {
	
	@Autowired
	DaoCustomer daoCustomer;
	
	@PostConstruct
	public void InitialisationData() {
		daoCustomer.save(new Customer(null, "Simon", "GRANIER", "123"));
		daoCustomer.save(new Customer(null, "Mathieu", "PROSIC", "456"));
		daoCustomer.save(new Customer(null, "Antoine", "CLEMENT", "789"));
	}
}