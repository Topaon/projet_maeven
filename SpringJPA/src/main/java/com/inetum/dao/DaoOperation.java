package com.inetum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.inetum.entity.Operation;

@Repository
@Transactional
public class DaoOperation implements InterfaceDaoOperation {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Operation> findAll() {
		return entityManager.createQuery("SELECT o FROM Operation o", Operation.class).getResultList();
	}

	@Override
	public Operation addOperation(Operation o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	public Operation getById(Integer id) {
		return entityManager.find(Operation.class, id);
	}

	@Override
	public void updateOperation(Operation o) {
		entityManager.merge(o);
	}

	@Override
	public void deleteOperationById(Integer id) {
		entityManager.remove(entityManager.find(Operation.class, id));
	}

}
