package com.inetum.TpSpring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	private List<Compte> comptes;
	
	public Customer(Long id, String firstname, String lastname, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.comptes = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", password=" + password
				+ "]";
	}



}