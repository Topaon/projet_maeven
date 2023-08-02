package com.inetum.TpSpring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.TpSpring.dao.DaoCompte;
import com.inetum.TpSpring.dao.DaoOperation;
import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Operation;
import com.inetum.TpSpring.exception.BankException;

@Service
@Transactional // <-- Les petites opérations effectuées par les sous-services se feront dans la même transaction que la méthode appelante.
			   //     Ainsi en cas de rollback toutes les opérations sont annulées.
			   //	  Si aucune transaction n'est créée, chaque opération entrainera la création et le commit d'une transaction dans les
			   //	  sous-services, et en cas de problème les autres modifications seront déjà commit, impossible de revenir en arrière
public class ServiceCompteImpl implements ServiceCompte {
	
	Logger logger = LoggerFactory.getLogger(ServiceCompteImpl.class);
	
	@Autowired
	private DaoCompte daoCompte;
	
	@Autowired
	private DaoOperation daoOperation;

	@Override
	public void transferer(Double montant, Long numCompteDeb, Long numCompteCred, String message) throws BankException {
		try {
			Double soldeTheoriqueApresDebit = daoCompte.findById(numCompteDeb).orElse(null).getSolde() - montant;
			Double decouvertAutorise = daoCompte.findById(numCompteDeb).orElse(null).decouvertAutorise;
			
			if(soldeTheoriqueApresDebit > decouvertAutorise) {
				debiterCompte(numCompteDeb, montant, message);
				crediterCompte(numCompteCred, montant, message);				
			} else {
				throw new BankException("Solde insuffisant vis-à-vis du découvert autorisé, pour un virement de " + montant);
			}
		} catch (Exception e) {
			logger.error("Echec virement, voici l'erreur : ", e); // Plutôt logger.error("Echec virement, voici l'erreur : ", e) pour une erreur propre
			logger.error(e.getMessage()); // A ajouter pour une erreur propre
			throw new BankException("Echec virement", e);
		}
	}

	@Override
	public void crediterCompte(Long numComptecred, Double montant, String message) {
		Compte compteCred = daoCompte.findById(numComptecred).orElse(null);
		compteCred.setSolde(compteCred.getSolde() + montant);
		daoCompte.save(compteCred);// <-- facultatif car dans un transactional toutes les modifications sont persistantes.
		   						   // 	  A la fin d'une transaction (commit) la fonction flush de JPA parcours tous les objets
		   						   // 	  remontés par des findBy(), ... etc et les persistes.
		
		daoOperation.save(new Operation(null, message, "credit", montant, compteCred));
	}
	
	@Override
	public void debiterCompte(Long numCompteDeb, Double montant, String message) {
		Compte compteDeb = daoCompte.findById(numCompteDeb).orElse(null);
		compteDeb.setSolde(compteDeb.getSolde() - montant);
		daoCompte.save(compteDeb);

		daoOperation.save(new Operation(null, message, "debit", montant, compteDeb));
	}

	@Override
	public List<Compte> rechercherComptesDuClient(Long numeroCustomer) {
		return daoCompte.findAll();
	}

	@Override
	public Compte sauvegarderCompte(Compte compte) {
		return daoCompte.save(compte);
	}

	@Override
	public void supprimerCompte(Long numeroCompte) {
		daoCompte.delete(daoCompte.findById(numeroCompte).orElse(null));
	}

	@Override
	public boolean verifierExistanceCompte(Long numeroCompte) {
		return daoCompte.existsById(numeroCompte);
	}

	@Override
	public Compte findCompteWithOperations(Long numeroCompte) {
		Compte cpt = daoCompte.rechercherCompteParNumeroAvecOperations(numeroCompte).get();
		return cpt;
	}

	@Override
	public Compte findCompteWithid(Long numeroCompte) {
		return daoCompte.findById(numeroCompte).orElse(null);
	}
}
