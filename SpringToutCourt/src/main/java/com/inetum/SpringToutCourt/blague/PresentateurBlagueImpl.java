package com.inetum.SpringToutCourt.blague;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PresentateurBlagueImpl implements PresentateurBlague {

	@Autowired
	@Qualifier("drole")
	private GenerateurBlagueDrole gbd;
	
	@Autowired
	@Qualifier("pasDrole")
	private GenerateurBlaguePasDrole gbpd;
	
	@Override
	public String presenterBlague() {
		return gbpd.getBlague();
	}
}