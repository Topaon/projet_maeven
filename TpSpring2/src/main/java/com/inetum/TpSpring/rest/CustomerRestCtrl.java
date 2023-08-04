package com.inetum.TpSpring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.TpSpring.dto.ApiError;
import com.inetum.TpSpring.dto.CustomerDto;
import com.inetum.TpSpring.entity.Compte;
import com.inetum.TpSpring.entity.Customer;
import com.inetum.TpSpring.service.ServiceCustomer;
import com.inetum.TpSpring.util.DtoGenericConverter;

@RestController
@RequestMapping(value = "/api-customer/customer", headers="Accept=application/json")
public class CustomerRestCtrl {

	@Autowired
	ServiceCustomer serviceCustomer;
	
	@GetMapping("")
	public List<CustomerDto> getAllCustomer() {
		return DtoGenericConverter.map(serviceCustomer.searchAll(), CustomerDto.class);
	}
	
	@GetMapping("/{idToFind}")
	public ResponseEntity<?> getCustomerById(@PathVariable(name = "idToFind") Long id) {
		Customer cust = serviceCustomer.searchById(id);
		if(cust == null) {
			return new ResponseEntity<ApiError>(new ApiError(HttpStatus.NOT_FOUND, "Erreur le compte n'existe pas"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<CustomerDto>(DtoGenericConverter.map(cust, CustomerDto.class), HttpStatus.OK);
		}
	}
	
	@PostMapping("")
	public Customer postCustomer(@RequestBody Customer customer) {
		return serviceCustomer.saveOrUpdate(customer);
	}
	
	@PutMapping("")
	public ResponseEntity<?> putCustomer(@RequestBody Customer customer){
		serviceCustomer.saveOrUpdate(customer);
		return new ResponseEntity<String>("Modifications enregistrées avec succès", HttpStatus.I_AM_A_TEAPOT);
	}
	
	@PutMapping("/reset/{idPwToReset}")
	public String resetPasswordById(@PathVariable(name = "idPwToReset") Long id) {
		return serviceCustomer.resetCustomerPassword(id);
	}
	
	@DeleteMapping("/{idToDelete}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable(value = "idToDelete") Long id ){
		serviceCustomer.deleteById(id);
		return new ResponseEntity<String>("Customer N°" + id + " supprimé avec succès", HttpStatus.I_AM_A_TEAPOT);
	}
}