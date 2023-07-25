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
		return entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
	}

	@Override
	public Client addClient(Client c) {
		// Comme on a mit @Transactional, à partir d'ici les objets appellés en base sont tenu à jour
		entityManager.persist(c);
		c.setNom("test"); // mais là on peut encore le modifier ça sera automatiquement mis à jour (à tester)
		return c;
		// Et à partir de là c'est fini (donc à l'endroit où la méthode a été appellée ça sera fini direct
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
