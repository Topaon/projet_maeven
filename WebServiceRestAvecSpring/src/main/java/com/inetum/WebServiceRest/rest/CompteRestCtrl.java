package com.inetum.WebServiceRest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.WebServiceRest.dao.InterfaceDaoCompte;
import com.inetum.WebServiceRest.entity.Compte;

@RestController
@RequestMapping(value="/api-bank/compte", headers="Accept=application/json")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST})
// permet l'appel depuis toutes les url, pas seulement celles commencant par 'http://localhost:8080'
// (un peu comme si on passait de private à public dans une classe)
public class CompteRestCtrl {

	@Autowired
	private InterfaceDaoCompte daoCompte;
	
//	 @RequestMapping(, method=RequestMethod.GET) Ancienne notation
	@GetMapping("/{numeroCompte}") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public Compte getCompteById(@PathVariable("numeroCompte") Long code) {
		daoCompte.save(new Compte(null, "Tristepin", 10.0));
		return daoCompte.findById(code).orElse(null);
	}

	@GetMapping("") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public List<Compte> getAllCompte(@RequestParam(value="soldeMini", required=false) Double soldeMini) {
		if(soldeMini == null) {
			System.out.println(soldeMini);
			return daoCompte.findAll();
		}
		else {
			System.out.println(soldeMini);
			return daoCompte.findBySoldeGreaterThanEqual(soldeMini);
		}
	}
	
	
	/**
	 * exemple de fin d'url : ./api-bank/compte
	 * Appellée en mode POST avec dans la partie invisble de la requète, BODY :
	 * { "numero" : null, "label" : "Label du compte", "solde" : 50d }
	 * @param compte
	 * @return
	 */
	@PostMapping("")
	public Compte postCompte(@RequestBody Compte compte) {
		return daoCompte.save(compte);
	}

	@PutMapping("")
	public ResponseEntity<?> putCompte(@RequestBody Compte compte) {
		Long numCompteToUpdate = compte.getNumero();
		Compte compteExistant = daoCompte.findById(numCompteToUpdate).orElse(null);
		if(compteExistant == null) {
			return new ResponseEntity<String>("{ \"err\" : \"compte not found\"}", HttpStatus.NOT_FOUND); // NOT_FOUND = 404
		}
		daoCompte.save(compte);
		return new ResponseEntity<Compte>(compte, HttpStatus.OK); // OK = 200
	}
//	VERSION avec le compte à supprimmer dans le body
	@DeleteMapping("")
	public ResponseEntity<?> deleteCompte(@RequestBody Compte compte) {
		daoCompte.deleteById(compte.getNumero());
		return new ResponseEntity<String>("Suppression réussie", HttpStatus.I_AM_A_TEAPOT);
	}
	
//	VERSION avec l'id du compte à supprimmer en paramètre de la requète
//	@DeleteMapping("")
//	public ResponseEntity<?> deleteByIdInParam(@RequestParam(value="idToDelete", required = false) Long id) {
//		System.out.println(id);
//		daoCompte.deleteById(id);
//		return new ResponseEntity<String>("Compte n°" + id + " supprimmé avec succès", HttpStatus.I_AM_A_TEAPOT);
//	}
	
//	VERSION avec l'id du compte à supprimmer en bout d'url sur la route
	@DeleteMapping("/{idToDelete}")
	public ResponseEntity<?> deleteCompteById(@PathVariable(value = "idToDelete") Long id) {
		System.out.println(id);
		daoCompte.deleteById(id);
		return new ResponseEntity<String>("Compte n°" + id + " supprimmé avec succès", HttpStatus.I_AM_A_TEAPOT);
	}
}