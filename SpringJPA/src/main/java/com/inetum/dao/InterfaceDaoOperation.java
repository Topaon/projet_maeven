package com.inetum.dao;

import java.util.List;

import com.inetum.entity.Operation;

public interface InterfaceDaoOperation {
	List<Operation> findAll();
	Operation addOperation(Operation o);
	Operation getById(Integer id);
	void updateOperation(Operation o);
	void deleteOperationById(Integer id);
}
