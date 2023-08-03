package com.inetum.TpSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.TpSpring.dao.DaoCustomer;
import com.inetum.TpSpring.entity.Customer;

@Service
@Transactional
public class ServiceCustomerImpl implements ServiceCustomer {

	@Autowired
	DaoCustomer daoCustomer;
	
	@Override
	public boolean checkCustomerPassword(Long customerId, String password) {
		String custPw = daoCustomer.findById(customerId).orElse(null).getPassword();
		// Attention == vérifie si les deux variables référencent la même chose (Deux String "123" différentes revéra donc false),
		// alors que .equals() vérifie que les entités référencées sont égales (ce qu'on veut la plupart du temps)
		if(custPw.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String resetCustomerPassword(Long id) {
		Customer cust = daoCustomer.findById(id).orElse(null);
		String newPassword = "0000";
		cust.setPassword(newPassword);
		return newPassword;
	}

	@Override
	public Customer rechercherSelonPrenomEtNom(String prenom, String nom) {
		Customer cust = daoCustomer.trouverCustomerDepuisSonPrenomEtSonNom(prenom, nom);
		return cust;
	}

	@Override
	public Customer creerCustomer(Customer customer) {
		return daoCustomer.save(customer);
	}

	@Override
	public Customer trouverCustomerViaId(Long id) {
		return daoCustomer.findById(id).orElse(null);
	}

	@Override
	public void MajCustomer(Customer customer) {
		daoCustomer.save(customer);
	}

	@Override
	public void supprimerCustomerViaId(Long id) {
		daoCustomer.delete(daoCustomer.findById(id).orElse(null));
	}
	
	@Override
	public List<Customer> rechercherSelonPrenomEtNomViaRequetesAutoSpring(String firstname, String lastname) {
		List<Customer> list = daoCustomer.findByFirstnameAndLastname(firstname, lastname);
		return list;
	}

	@Override
	public List<Customer> trouverTousLesCustomer() {
		return daoCustomer.findAll();
	}
}
