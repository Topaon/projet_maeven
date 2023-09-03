package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.DaoVoiture;
import com.example.demo.entity.Voiture;

public class VoitureService {
	
	@Autowired
	DaoVoiture daoVoiture;
	
	public void testVoiture() {
		Voiture clio = new Voiture();
		clio.setMarque("Renault");
		clio.setModele("Clio");
		dao
		System.out.println(clio);
	}
	
}
