package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.DaoVoiture;
import com.example.demo.entity.Voiture;
import com.example.demo.service.VoitureService;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	DaoVoiture daoVoiture;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
