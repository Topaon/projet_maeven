package com.inetum.WebServiceRest.dao;

import java.util.List;

import com.inetum.WebServiceRest.entity.Compte;

public interface InterfaceDaoCompte {
	List<Compte> findAll();
	Compte addCompte(Compte c);
	Compte getById(Integer id);
	void updateCompte(Compte c);
	void deleteCompteById(Integer id);
	List<Compte> findBySoldeMini(Double soldeMin);
	List<Compte> findBySoldeMax(Double soldeMax);
}
