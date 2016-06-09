package com.adaming.proxiBanqueSI.service;

import java.util.List;

import com.adaming.proxiBanqueSI.model.Client;

public interface IBanqueService {

	public List<Client> getAllClients();
	public void addClient (Client pClient);
	public boolean virement (String numClientDebite, String numClientCredite, double montant);
}
