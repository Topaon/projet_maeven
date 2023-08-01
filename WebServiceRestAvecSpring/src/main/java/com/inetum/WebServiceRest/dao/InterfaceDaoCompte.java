package com.inetum.WebServiceRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.WebServiceRest.entity.Compte;

public interface InterfaceDaoCompte extends JpaRepository<Compte, Long> {
	List<Compte> findBySoldeGreaterThanEqual(Double soldeMin);
	List<Compte> findBySoldeLessThanEqual(Double soldeMax);
	
	// Attention pour que Spring s'y retrouve avec les NamedQuery le nom définie dans l'entité doit être : NomDeLaClasse.nomDeLaFonction
	// Et liée ici avec juste nomDeLaFonction
	List<Compte> allCompteWithMin(Double soldeMin);
	
	// Ces méthodes généré par Spring (comme on a JpaRespository)
//	Compte addCompte(Compte c);
//	Compte getById(Integer id);
//	void updateCompte(Compte c);
}