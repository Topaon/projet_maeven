package sg.corporation.entrainement_WSR.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import sg.corporation.entrainement_WSR.entity.Champion;

@Repository
@Transactional
public class DaoChampion implements InterfaceDaoChampion {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Champion> getAll() {
		return entityManager.createQuery("SELECT c FROM Champion c", Champion.class).getResultList();
	}

	@Override
	public Champion getById(Integer id) {
		return entityManager.find(Champion.class, id);
	}

	@Override
	public Champion addChampion(Champion c) {
		entityManager.persist(c);
		return c;
	}

	@Override
	public void updateChampion(Champion c) {
		entityManager.merge(c);
	}

	@Override
	public void deleteChampionById(Integer id) {
		entityManager.remove(entityManager.find(Champion.class, id));
	}
}
