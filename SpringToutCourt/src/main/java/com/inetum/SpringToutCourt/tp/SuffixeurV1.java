package com.inetum.SpringToutCourt.tp;

import org.springframework.stereotype.Component;

@Component
public class SuffixeurV1 implements ISuffixeur {

private String suffixe="**";
	
	@Override
	public String suffixer(String c) {
		// TODO Auto-generated method stub
		return c+suffixe;
	}

	@Override
	public String suffixerMaj(String c) {
		// TODO Auto-generated method stub
		return c.toUpperCase()+suffixe;
	}
}