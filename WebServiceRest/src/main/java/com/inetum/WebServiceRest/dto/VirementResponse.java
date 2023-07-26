package com.inetum.WebServiceRest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VirementResponse {
	private Integer numCompteDebit;
	private Integer numCompteCredit;
	private Double montant;
	private Boolean status;
	private String message;
	
	@Override
	public String toString() {
		return "VirementResponse [numCompteDebit=" + numCompteDebit + ", numCompteCredit=" + numCompteCredit
				+ ", montant=" + montant + ", message=" + message + "]";
	}
}