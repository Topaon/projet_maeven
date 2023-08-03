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

import com.inetum.TpSpring.dao.DaoCustomer;
import com.inetum.TpSpring.entity.Customer;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceCustomer {

	Logger log = LoggerFactory.getLogger(TestServiceCustomer.class);
	
	@Autowired
	ServiceCustomer serviceCustomer;
	
	@Test
	public void testCheckPassword() {
		Customer cust1 = serviceCustomer.creerCustomer(new Customer(null, "Simon", "GRANIER", "123"));
		
		assertTrue(serviceCustomer.checkCustomerPassword(cust1.getId(), "123"));
		assertFalse(serviceCustomer.checkCustomerPassword(cust1.getId(), "321"));
		
		
	}
	
	@Test
	public void testResetPassword() {
		Customer cust2 = serviceCustomer.creerCustomer(new Customer(null, "Mathieu", "PROSIC", "456"));
		
		String newPassword = serviceCustomer.resetCustomerPassword(cust2.getId());
		assertEquals(newPassword, serviceCustomer.trouverCustomerViaId(cust2.getId()).getPassword());
	}
	
	@Test
	public void testRechercherSelonPrenomEtNom() {
		Customer cust3 = serviceCustomer.creerCustomer(new Customer(null, "Antoine", "CLEMENT", "789"));
		
		Customer cust3viaRspen = serviceCustomer.rechercherSelonPrenomEtNom("Antoine", "CLEMENT");
		
		assertEquals(cust3.toString(), cust3viaRspen.toString());
	}
	
	@Test
	public void testRechercherSelonPrenomEtNomViaRequetesAutoSpring() {
		Customer cust4 = serviceCustomer.creerCustomer(new Customer(null, "Simon", "GRANIER", "123"));
		Customer cust5 = serviceCustomer.creerCustomer(new Customer(null, "Simon", "GRANIER", "456"));
		Customer cust6 = serviceCustomer.creerCustomer(new Customer(null, "Simon", "GRANIER", "789"));
		
		for(Customer c:serviceCustomer.rechercherSelonPrenomEtNomViaRequetesAutoSpring("Simon", "GRANIER")) {
			log.trace(c.toString());
		}
	}
}
