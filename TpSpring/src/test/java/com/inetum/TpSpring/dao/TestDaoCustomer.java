package com.inetum.TpSpring.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.TpSpring.entity.Customer;

@SpringBootTest
public class TestDaoCustomer {
	
	@Autowired
	DaoCustomer daoCustomer;
	
	@Test
	public void testCustomer() {
		daoCustomer.save(new Customer(null, "Simon", "GRANIER", "123"));
		daoCustomer.save(new Customer(null, "Mathieu", "PROSIC", "456"));
		daoCustomer.save(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		System.out.println(daoCustomer.findAll().size());
	}
	
}
