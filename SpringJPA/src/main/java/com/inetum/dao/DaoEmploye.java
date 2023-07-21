package com.inetum.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.entity.Employe;

@Repository
@Transactional
public class DaoEmploye implements InterfaceDaoEmploye {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Employe findById(Integer id) {
		return entityManager.find(Employe.class, id);
	}

	@Override
	public List<Employe> findAll() {
		return entityManager.createQuery("SELECT e FROM Employe e", Employe.class).getResultList();
	}
	
	@Override
	public List<Employe> findByPrenom(String pre) {
		return entityManager.createNamedQuery("Employe.allWithSurname", Employe.class).setParameter(1, pre)
				.getResultList();
	}

	@Override
	public Employe insertEmploye(Employe emp) {
		entityManager.persist(emp);
		return emp;
	}

	@Override
	public void updateEmploye(Employe emp) {
		entityManager.merge(emp);
	}

	@Override
	public void deleteEmployeById(Integer id) {
		Employe empAsupprimer = entityManager.find(Employe.class, id);
		entityManager.remove(empAsupprimer);
	}
}
