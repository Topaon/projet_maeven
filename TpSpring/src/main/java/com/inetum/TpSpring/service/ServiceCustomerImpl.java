package com.inetum.TpSpring.service;

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
		// Essayer des sysout partout pour voir si les pw récup sont bon
		if(custPw == password) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String resetCustomerPassword(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer rechercherSelonPrenomEtNom(String prenom, String nom) {
		// TODO Auto-generated method stub
		return null;
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
}
