package com.inetum.TpSpring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.TpSpring.entity.Customer;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceCustomer {

	Logger log = LoggerFactory.getLogger(TestServiceCustomer.class);
	
	@Autowired
	ServiceCustomer serviceCustomer;
	
	@Test
	public void testQueries() {
		Customer cust1 = serviceCustomer.saveOrUpdate(new Customer(null, "John", "WICK", "123"));
		
		assertTrue(serviceCustomer.existById(cust1.getId()));
		
		assertEquals(cust1.toString(), serviceCustomer.searchById(cust1.getId()).toString());
		
		cust1.setPassword("321");
		serviceCustomer.saveOrUpdate(cust1);
		
		assertEquals(cust1.getPassword(), serviceCustomer.searchById(cust1.getId()).getPassword());
		
		serviceCustomer.deleteById(cust1.getId());
		assertEquals(null, serviceCustomer.searchById(cust1.getId()));
	}
	
	@Test
	public void testCheckPassword() {
		Customer cust2 = serviceCustomer.saveOrUpdate(new Customer(null, "Jason", "STATAN", "123"));
		
		assertTrue(serviceCustomer.checkCustomerPassword(cust2.getId(), "123"));
		assertFalse(serviceCustomer.checkCustomerPassword(cust2.getId(), "321"));
	}
	
	@Test
	public void testResetPassword() {
		Customer cust3 = serviceCustomer.saveOrUpdate(new Customer(null, "Mathieu", "PROSIC", "456"));
		
		String newPassword = serviceCustomer.resetCustomerPassword(cust3.getId());
		assertEquals(newPassword, serviceCustomer.searchById(cust3.getId()).getPassword());
	}
	
	@Test
	public void testRechercherSelonPrenomEtNom() {
		Customer cust4 = serviceCustomer.saveOrUpdate(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		Customer cust4viaRspen = serviceCustomer.rechercherSelonPrenomEtNom("Antoine", "CLEMENT");
		
		assertEquals(cust4.toString(), cust4viaRspen.toString());
	}
	
	@Test
	public void testRechercherSelonPrenomEtNomViaRequetesAutoSpring() {
		Customer cust5 = serviceCustomer.saveOrUpdate(new Customer(null, "Simon", "GRANIER", "123"));
		Customer cust6 = serviceCustomer.saveOrUpdate(new Customer(null, "Simon", "GRANIER", "456"));
		Customer cust7 = serviceCustomer.saveOrUpdate(new Customer(null, "Simon", "GRANIER", "789"));
		
		for(Customer c:serviceCustomer.rechercherSelonPrenomEtNomViaRequetesAutoSpring("Simon", "GRANIER")) {
			log.trace(c.toString());
		}
	}
}
