package com.inetum.TpSpring.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// La DTO Compte sera une représentation partielle simplifiée de entity.Compte

@Getter @Setter @NoArgsConstructor
public class CompteDto {
	private Long id;
	private String label;
	private Double solde;
	
	public CompteDto(Long id, String label, Double solde) {
		super();
		this.id = id;
		this.label = label;
		this.solde = solde;
	}
}