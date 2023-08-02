package com.inetum.TpSpring.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.inetum.TpSpring.dao.DaoCustomer;
import com.inetum.TpSpring.entity.Customer;

@SpringBootTest
public class TestServiceCustomer {

	Logger log = LoggerFactory.getLogger(TestServiceCustomer.class);
	
	@Autowired
	ServiceCustomer serviceCustomer;
	
	@Test
	public void testCheckPassword() {
		Customer cust1 = serviceCustomer.creerCustomer(new Customer(null, "Simon", "GRANIER", "123"));
//		Customer cust2 = serviceCustomer.creerCustomer(new Customer(null, "Mathieu", "PROSIC", "456"));
//		Customer cust3 = serviceCustomer.creerCustomer(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		log.trace("Resultat du check : " + serviceCustomer.checkCustomerPassword(cust1.getId(), "123"));
		
		assertTrue(serviceCustomer.checkCustomerPassword(cust1.getId(), "123"));
		assertFalse(serviceCustomer.checkCustomerPassword(cust1.getId(), "321"));
		
	}

}
