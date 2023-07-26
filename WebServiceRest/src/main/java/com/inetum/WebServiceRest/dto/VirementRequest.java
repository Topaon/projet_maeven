package com.inetum.WebServiceRest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VirementRequest {
	private Integer numCompteDebit;
	private Integer numCompteCredit;
	private Double montant;
	
	@Override
	public String toString() {
		return "VirementRequest [numCompteDebit=" + numCompteDebit + ", numCompteCredit=" + numCompteCredit
				+ ", montant=" + montant + "]";
	}
}