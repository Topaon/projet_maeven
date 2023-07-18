package com.inetum.mbean;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class User {
	private String nomUtil;
	private String mdp;
	private Boolean isConnected = false;
	
	public String login() {
		String suite = null;
		if(this.nomUtil != null && this.mdp != null && this.mdp.equals("totalement interdit")) {
			this.isConnected = true;
			suite = "user";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login fail", "Mot de passe incorrect"));
			nomUtil = "";
			isConnected = false;
		}
		return suite;
	}
	
	
	// GETTER SETTER
	public String getNomUtil() {
		return nomUtil;
	}

	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Boolean getIsConnected() {
		return isConnected;
	}

	public void setIsConnected(Boolean isConnected) {
		this.isConnected = isConnected;
	}	
}
