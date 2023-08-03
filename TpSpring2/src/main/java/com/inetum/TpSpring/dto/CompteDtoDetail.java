package com.inetum.TpSpring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Version détaillée de CompteDto

@Getter @Setter @NoArgsConstructor
public class CompteDtoDetail extends CompteDto {
	private Long idClient;
}
