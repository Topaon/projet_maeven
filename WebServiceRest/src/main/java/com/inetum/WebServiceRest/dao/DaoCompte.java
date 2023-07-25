package com.inetum.WebServiceRest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.WebServiceRest.entity.Compte;

@Repository
@Transactional
public class DaoCompte implements InterfaceDaoCompte {
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Compte> findAll() {
		return entityManager.createQuery("SELECT c FROM Compte c", Compte.class).getResultList();
	}

	@Override
	public Compte addCompte(Compte c) {
		entityManager.persist(c);
		return c;
	}

	@Override
	public Compte getById(Integer id) {
		Compte c = new Compte();
		c = entityManager.find(Compte.class, id);
		return c;
	}

	@Override
	public void updateCompte(Compte c) {
		entityManager.merge(c);
	}

	@Override
	public void deleteCompteById(Integer id) {
		Compte c = entityManager.find(Compte.class, id);
		entityManager.remove(c);
	}

	@Override
	public List<Compte> findBySoldeMini(Double soldeMin) {
		return entityManager.createNamedQuery("allCompteWithMin", Compte.class).setParameter(1, soldeMin).getResultList();
	}

	@Override
	public List<Compte> findBySoldeMax(Double soldeMax) {
		return entityManager.createNamedQuery("allCompteWithMax", Compte.class).setParameter(1, soldeMax).getResultList();
	}
}
