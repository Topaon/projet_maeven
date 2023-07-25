package com.inetum.WebServiceRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceRestApplication.class, args);
		System.out.println("http://localhost:8080/WebServiceRest");
	}
}