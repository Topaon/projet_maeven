package com.inetum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.entity.Personne;

@Repository
@Transactional
public class DaoPersonne {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Personne> findAll() {
		return entityManager.createQuery("SELECT c FROM Personne c", Personne.class).getResultList();
	}

	public Personne addPersonne(Personne c) {
		entityManager.persist(c);
		return c;
	}

	public Personne getById(Integer id) {
		return entityManager
				.createNamedQuery("Personne.getById", Personne.class)
				.setParameter(1, id)
				.getSingleResult();
	}

	public void updatePersonne(Personne c) {
		entityManager.merge(c);
	}

	public void deletePersonneById(Integer id) {
		entityManager.remove(entityManager.find(Personne.class, id));
	}
}
