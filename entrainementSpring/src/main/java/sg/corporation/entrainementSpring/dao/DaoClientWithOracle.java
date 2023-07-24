package sg.corporation.entrainementSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import sg.corporation.entrainementSpring.entity.Client;

@Repository
@Transactional
public class DaoClientWithOracle implements InterfaceDaoClient {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> allClients() {		
		return em.createNamedQuery("Client.getAllClients", Client.class).getResultList();
	}

	@Override
	public Client getById(Integer id) {
		return em.find(Client.class, id);
	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
	}

	@Override
	public void deleteClientById(Integer id) {
		em.remove(em.find(Client.class, id));
	}
}