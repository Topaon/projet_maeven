package com.inetum.TpSpring.util;

import java.util.List;

import com.inetum.TpSpring.dto.CompteDto;
import com.inetum.TpSpring.entity.Compte;

public class DtoConverter {
	
	public static List<CompteDto> compteToCompteDto(List<Compte> entityList) {
		return entityList.stream()
				         .map((entity)->compteToCompteDto(entity))
				         .toList();
	}

	public static CompteDto compteToCompteDto(Compte entity) {
		/*return new CompteDto(entity.getNumero() , 
				             entity.getLabel(),
				             entity.getSolde());*/
		
		CompteDto compteDto = new CompteDto();
		
		compteDto.setId(entity.getId());
		compteDto.setLabel(entity.getLabel());
		compteDto.setSolde(entity.getSolde());
		
		//BeanUtils.copyProperties(entity, compteDto); //compact/écriture concise mais pas rapide
		return compteDto;
	}
	
	public static Compte compteDtoToCompte(CompteDto dto) {
		return new Compte(dto.getId(), dto.getLabel(), dto.getSolde());
	}
}