package com.inetum.dao;

import java.util.List;

import com.inetum.entity.Compte;

// Ici E va remplacer l'entité persistante, et PK remplacera le type de clé primaire
public interface DaoGeneric<E, PK> {
	List<E> findAll();
	E addCompte(E c);
	E getById(PK id);
	void updateCompte(E c);
	void deleteCompteById(PK id);
}
