package sg.corporation.entrainementSpring.dao;

import java.util.List;

import sg.corporation.entrainementSpring.entity.Commande;

public interface InterfaceDaoCommande {
	List<Commande> allCommandes();
	Commande getById(Integer id);
	Commande addCommande(Commande c);
	void updateCommande(Commande c);
	void deleteCommandeById(Integer id);
}
