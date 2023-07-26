package com.inetum.WebServiceRest.rest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.WebServiceRest.dao.DaoCompte;
import com.inetum.WebServiceRest.dto.VirementRequest;
import com.inetum.WebServiceRest.dto.VirementResponse;
import com.inetum.WebServiceRest.entity.Compte;

@RestController
@RequestMapping(value="/api-bank/virement", headers="Accept=application/json")
public class VirementRestCtrl {
	
	@Autowired
	private DaoCompte daoCompte;
	
	@PostMapping("")
	public VirementResponse postVirement(@RequestBody VirementRequest vireq) {
		VirementResponse vires = new VirementResponse();
		
//		vires.setMontant(vireq.getMontant());
//		vires.setNumCompteCredit(vireq.getNumCompteCredit());
//		vires.setNumCompteDebit(vireq.getNumCompteDebit());
		// Simplifie les 3 lignes en commentaire ci-dessus
		BeanUtils.copyProperties(vireq, vires);
		
		try {
			Compte compteADebiter = daoCompte.getById(vireq.getNumCompteDebit());
			compteADebiter.setSolde(compteADebiter.getSolde() - vireq.getMontant());
			daoCompte.updateCompte(compteADebiter);
			
			Compte compteACrediter = daoCompte.getById(vireq.getNumCompteCredit());
			compteACrediter.setSolde(compteACrediter.getSolde() + vireq.getMontant());
			daoCompte.updateCompte(compteACrediter);
			
			vires.setStatus(true);
			vires.setMessage("Virement bien effectué");
		} catch (Exception e) {
			vires.setStatus(false);
			vires.setMessage("Erreur fatale,  le virement n'a pas pu être effectué");
		}
		return vires;
	}
}
