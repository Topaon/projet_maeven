package com.inetum.TpSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	
	public Compte(Long id, String label) {
		super();
		this.id = id;
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", label=" + label + "]";
	}
}