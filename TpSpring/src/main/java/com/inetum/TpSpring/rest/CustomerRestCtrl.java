package com.inetum.TpSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.TpSpring.entity.Customer;
import com.inetum.TpSpring.service.ServiceCustomer;

@RestController
@RequestMapping(value = "/api-customer/customer", headers="Accept=application/json")
public class CustomerRestCtrl {

	@Autowired
	ServiceCustomer serviceCustomer;
	
	@GetMapping("")
	public List<Customer> getAllCustomer() {
		return serviceCustomer.trouverTousLesCustomer();
	}
}