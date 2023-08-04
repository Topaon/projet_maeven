package com.inetum.TpSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSpringApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "init");
		SpringApplication.run(TpSpringApplication.class, args);
		System.out.println("Application lancée à l'url suivante : http://localhost:8080/TpSpring");
	}
}