package com.inetum.TpSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.TpSpring.dto.CompteDto;
import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.service.ServiceCompte;
import com.inetum.TpSpring.util.DtoGenericConverter;

@RestController
@RequestMapping(value = "/api-compte/compte", headers="Accept=application/json")
public class CompteRestCtrl {

	@Autowired
	ServiceCompte serviceCompte;
	
	@GetMapping("")
	public List<CompteDto> getAllCustomer() {
		return DtoGenericConverter.map((serviceCompte.trouverTousLesComptes()), CompteDto.class);
	}
	
	@GetMapping("/{numeroCompte}") // s'il n'y a qu'un seul parametre le 'value=' est facultatif
	public Compte getCompteById(@PathVariable("numeroCompte") Long code) {
		return serviceCompte.searchById(code);
	}
	
	@PostMapping("")
	public Compte postCompte(@RequestBody Compte compte) {
		return serviceCompte.saveOrUpdate(compte);
	}
	
	@PutMapping("")
	public ResponseEntity<?> putCompte(@RequestBody Compte compte){
		serviceCompte.saveOrUpdate(compte);
		return new ResponseEntity<String>("Modifications enregistrées avec succès", HttpStatus.I_AM_A_TEAPOT);
	}
	
	@DeleteMapping("/{idToDelete}")
	public ResponseEntity<?> deleteCompteById(@PathVariable(value = "idToDelete") Long id ){
		serviceCompte.supprimerCompte(id);
		return new ResponseEntity<String>("Compte N°" + id + " supprimé avec succès", HttpStatus.I_AM_A_TEAPOT);
	}
}