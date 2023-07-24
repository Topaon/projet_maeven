package sg.corporation.entrainementSpring.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.corporation.entrainementSpring.entity.Client;
import sg.corporation.entrainementSpring.entity.Commande;

@SpringBootTest
public class TestDaoCommande {
Logger log = LoggerFactory.getLogger(Commande.class);
	
	@Autowired
	DaoCommande dcom;
	
	@Autowired
	DaoClient dcli;
	
	@Test
	public void testDaoCommande() {
		Client cA = new Client(null, "Granier", "s@sfr.fr");
		Client cB = new Client(null, "Granier", "j@sfr.fr");
		
		Commande c1 = new Commande(null, "Achat Elden Ring", cA);
		Commande c2 = new Commande(null, "Week-end LA2", cA);
		Commande c3 = new Commande(null, "Achat PS4", cB);
		
		cA.getCommandes().add(c1);
		cA.getCommandes().add(c2);
		cB.getCommandes().add(c3);
		
		dcli.addClient(cA);
		dcli.addClient(cB);
		
		dcom.addCommande(c1);
		dcom.addCommande(c2);
		dcom.addCommande(c3);
		
		
		log.trace(dcom.getById(1).toString());
		
		assertEquals(c1.getId(), 1);
		assertEquals(c2.getId(), 2);
		
		List<Commande> Commandes = dcom.allCommandes();
		for(Commande c:Commandes) {
			log.trace(c.toString());
		}
		assertEquals(Commandes.size(), 3);
		
		c3.setLabel("Achat PS5");
		dcom.updateCommande(c3);
		
		dcom.deleteCommandeById(c1.getId());
	}
}