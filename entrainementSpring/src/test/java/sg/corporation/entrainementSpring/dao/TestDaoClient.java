package sg.corporation.entrainementSpring.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sg.corporation.entrainementSpring.entity.Client;
import sg.corporation.entrainementSpring.entity.Commande;

@SpringBootTest
public class TestDaoClient {
	Logger log = LoggerFactory.getLogger(Client.class);
	
	@Autowired
	DaoClient dcli;
	
	@Autowired
	DaoCommande dcom;
	
	@Test
	public void testForeignKey() {
		Client cA = new Client(null, "Simon GRANIER", "s@sfr.fr");
		Client cB = new Client(null, "Judith GRANIER", "j@sfr.fr");
		
		Commande c1 = new Commande(null, "Achat Elden Ring", cA);
		Commande c2 = new Commande(null, "Week-end LA2", cA);
		Commande c3 = new Commande(null, "Achat tente", cB);
		Commande c4 = new Commande(null, "Achat Leroy Merlin", cB);
		
		cA.getCommandes().add(c1);
		cA.getCommandes().add(c2);
		cA.getCommandes().add(c3);
		cB.getCommandes().add(c4);
		
		dcli.addClient(cA);
		dcli.addClient(cB);
		
		dcom.addCommande(c1);
		dcom.addCommande(c2);
		dcom.addCommande(c3);
		dcom.addCommande(c4);
		
		List<Client> clients = dcli.allClients();
		for(Client c : clients) {
			for(Commande com : c.getCommandes()) {
				System.out.println("Commande : " + com.getLabel() + " passée par : " + c.getNom());
			}
		}
	}
}