package com.inetum.TpSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.TpSpring.entity.Operation;

public interface DaoOperation extends JpaRepository<Operation, Long> {

}
