package sg.corporation.entrainementSpring.dao;

import java.util.List;

import sg.corporation.entrainementSpring.entity.Client;

public interface InterfaceDaoClient {
	List<Client> allClients();
	Client getById(Integer id);
	Client addClient(Client c);
	void updateClient(Client c);
	void deleteClientById(Integer id);
}