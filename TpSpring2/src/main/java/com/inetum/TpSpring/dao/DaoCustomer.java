package com.inetum.TpSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.TpSpring.entity.Customer;

public interface DaoCustomer extends JpaRepository<Customer, Long> {
	Customer trouverCustomerDepuisSonPrenomEtSonNom(String prenom, String nom);
	List<Customer> findByFirstnameAndLastname(String firstname, String lastname);
}