package tp.dao;

import java.util.List;

import tp.entity.Personne;

public interface PersonneDao {
	
	public Personne createPersonne(Personne p);
	public Personne searchPersonneById(Integer id);
	public List<Personne> searchAllPersonne();
	public void updatePersonne(Personne p);
	public void deletePersonne(Integer id);

}
