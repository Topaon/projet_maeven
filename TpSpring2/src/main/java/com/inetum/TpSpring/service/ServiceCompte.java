package com.inetum.TpSpring.service;

import java.util.List;

import com.inetum.TpSpring.dto.CompteDto;
import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.exception.BankException;

public interface ServiceCompte extends GenericService<Compte, Long, CompteDto>{
	// Méthodes spécifiques au métier de la banque
	void debiterCompte(Long numCompteDeb, Double montant, String message);
	void crediterCompte(Long numComptecred, Double montant, String message);
	void transferer(Double montant, Long numCompteDeb, Long numCompteCred, String message) throws BankException;	
	public Compte findCompteWithOperations(Long numeroCompte);
	
	// Méthodes déléguées aux DAOs, pour ne pas passer directement des services web aux dao (respect des couches web/métier/dao)
	List<Compte> rechercherComptesDuClient(Long numeroCustomer);
	void supprimerCompte(Long numeroCompte);
	boolean existById(Long numeroCompte);
	List<Compte> trouverTousLesComptes();
	
	// On va rendre generic ces méthodes
//	public Compte searchById(Long numeroCompte);
//	Compte saveOrUpdate(Compte compte);
}