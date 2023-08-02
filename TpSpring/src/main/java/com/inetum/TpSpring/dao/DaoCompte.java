package com.inetum.TpSpring.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.TpSpring.entity.Compte;

public interface DaoCompte extends JpaRepository<Compte, Long> {
	Optional<Compte> rechercherCompteParNumeroAvecOperations(Long numeroCompte); // Renvoie les operations avec
}
