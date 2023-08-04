package com.inetum.TpSpring.service;

import java.util.List;

import com.inetum.TpSpring.dto.CustomerDto;
import com.inetum.TpSpring.entity.Customer;

public interface ServiceCustomer extends GenericService<Customer, Long, CustomerDto> {
	boolean checkCustomerPassword(Long customerId, String password);
	String resetCustomerPassword(Long id);
	Customer rechercherSelonPrenomEtNom(String prenom, String nom);
	List<Customer> rechercherSelonPrenomEtNomViaRequetesAutoSpring(String firstname, String lastname);
}