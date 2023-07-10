package tp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tp.entity.Personne;


// Version simulée d'une bdd
public class PersonneDaoSimu implements PersonneDao {
	
	private Map<Integer, Personne> mapIdPersonne = new HashMap<>();
	Integer idMax = 0;
	
	
	@Override
	public Personne createPersonne(Personne p) {
		p.setId(++idMax);
		mapIdPersonne.put(p.getId(), p);
		return p;
	}
	
	@Override
	public Personne searchPersonneById(Integer id) {
		return mapIdPersonne.get(id);
	}
	
	@Override
	public List<Personne> searchAllPersonne() {
		return new ArrayList<Personne>(mapIdPersonne.values());
	}
	
	@Override
	public void updatePersonne(Personne p) {
		mapIdPersonne.put(p.getId(), p);
	}
	
	@Override
	public void deletePersonne(Integer id) {
		mapIdPersonne.remove(id);
		
	}

	
}
