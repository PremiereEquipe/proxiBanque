package com.adaming.proxiBanqueSI.dao;

import java.util.List;

import com.adaming.proxiBanqueSI.model.Client;

public interface IClientDao {
	void addClient(Client client);
	public List<Client> getAllClient();
}
