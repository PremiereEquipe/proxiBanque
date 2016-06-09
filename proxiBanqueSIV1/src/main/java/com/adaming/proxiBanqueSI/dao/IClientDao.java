package com.adaming.proxiBanqueSI.dao;

import java.util.List;

import com.adaming.proxiBanqueSI.model.Client;

public interface IClientDao {
	void addClient(Client pClient);
	void updateClient(Client pClient);
	void deleteClient(Client pClient);
	Client getClientById(int idClient);
	public List<Client> getAllClient();
}
