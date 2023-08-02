package com.inetum.TpSpring.service;

import com.inetum.TpSpring.entity.Customer;

public interface ServiceCustomer {
	// Fonctions métier spécifiques
	// ça c'est les méthodes du tp à implémenter :
	boolean checkCustomerPassword(Long customerId, String password);
	String resetCustomerPassword(Long id);
	Customer rechercherSelonPrenomEtNom(String prenom, String nom);
	
	// Fonctions DAO à relier à la partie service
	// CRUUUUUUUD !!
	// C stand for : Create
	Customer creerCustomer(Customer customer);
	// R stand for : Read
	Customer trouverCustomerViaId(Long id);
	// U stand for : Update
	void MajCustomer(Customer customer);
	// D stand for : Delete
	void supprimerCustomerViaId(Long id);
}
