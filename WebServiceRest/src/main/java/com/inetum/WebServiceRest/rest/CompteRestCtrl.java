package com.inetum.WebServiceRest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.WebServiceRest.dao.DaoCompte;
import com.inetum.WebServiceRest.entity.Compte;

@RestController
@RequestMapping(value="/api-bank/compte", headers="Accept=application/json")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST})
// permet l'appel depuis toutes les url, pas seulement celles commencant par 'http://localhost:8080'
// (un peu comme si on passait de private à public dans une classe)
public class CompteRestCtrl {

	@Autowired
	private DaoCompte daoCompte;
	
	// @RequestMapping(, method=RequestMethod.GET) Ancienne notation
	@GetMapping("/{numeroCompte}") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public Compte getCompteById(@PathVariable("numeroCompte") Integer code) {
		daoCompte.addCompte(new Compte(null, "Tristepin", 10.0));
		return daoCompte.getById(code);
	}

	@GetMapping("/all") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public List<Compte> getAllCompte() {
		return daoCompte.findAll();
	}
	
	@GetMapping("/min/{soldeMin}") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public List<Compte> getAllCompte(@PathVariable("soldeMin") Double min) {
		return daoCompte.findBySoldeMini(min);
	}
}