package com.inetum.dao;

import java.util.List;

import com.inetum.entity.Client;

public interface InterfaceDaoClient {
	List<Client> findAll();
	Client addClient(Client c);
	Client getById(Integer id);
	void updateClient(Client c);
	void deleteClientById(Integer id);
}
