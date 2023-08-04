package com.inetum.TpSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// La DTO Compte sera une représentation partielle simplifiée de entity.Compte

@Getter @Setter @NoArgsConstructor
public class CustomerDto {
	private Long id;
	private String firstname;
	private String lastname;
	
	public CustomerDto(Long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}
}