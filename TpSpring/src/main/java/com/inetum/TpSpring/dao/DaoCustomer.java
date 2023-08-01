package com.inetum.TpSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.TpSpring.entity.Customer;

public interface DaoCustomer extends JpaRepository<Customer, Long> {

}
