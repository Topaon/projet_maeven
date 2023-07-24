package sg.corporation.entrainementSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import sg.corporation.entrainementSpring.entity.Commande;

@Repository
@Transactional
public class DaoCommande implements InterfaceDaoCommande {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commande> allCommandes() {		
		return em.createQuery("SELECT c FROM Commande c", Commande.class).getResultList();
	}

	@Override
	public Commande getById(Integer id) {
		return em.find(Commande.class, id);
	}

	@Override
	public Commande addCommande(Commande c) {
		em.persist(c);
		return c;
	}

	@Override
	public void updateCommande(Commande c) {
		em.merge(c);
	}

	@Override
	public void deleteCommandeById(Integer id) {
		em.remove(em.find(Commande.class, id));
	}
}
