package com.inetum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.entity.Client;

@Repository
@Transactional
public class DaoClient implements InterfaceDaoClient {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Client> findAll() {
		return entityManager.createQuery("SELECT c FROM client c", Client.class).getResultList();
	}

	@Override
	public Client addClient(Client c) {
		entityManager.persist(c);
		return c;
	}

	@Override
	public Client getById(Integer id) {
		return entityManager
				.createNamedQuery("Client.getById", Client.class)
				.setParameter(1, id)
				.getSingleResult();
	}

	@Override
	public void updateClient(Client c) {
		entityManager.merge(c);
	}

	@Override
	public void deleteClientById(Integer id) {
		entityManager.remove(entityManager.find(Client.class, id));
	}

}