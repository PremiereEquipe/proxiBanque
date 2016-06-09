package com.adaming.proxiBanqueSI.service;

import java.util.List;

import com.adaming.proxiBanqueSI.model.Client;

public interface IBanqueService {

	public List<Client> getAllClients();
	public void addClient (Client pClient);
	public boolean virement (Client client1, Client client2, double montant);
}
