package com.adaming.proxiBanqueSI.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.dao.ClientDaoImpl;

public class BanqueServiceImpl implements IBanqueService, Serializable{

	private static final long serialVersionUID = 1L;
	
	// injection auto du DAO
	@Autowired
	private ClientDaoImpl clientDAO;
	
	/**
	 * Return a list of all the clients in the DB.
	 */
	public List<Client> getAllClients() {
		
		return clientDAO.getAllClient();
	}

	public void addClient (Client pClient) {
		clientDAO.addClient(pClient);
	}
	
	/**
	 * R�cup�ration d'un client par son identifiant.
	 * @param pId
	 * @return
	 */
	public Client getClientById (int pId) {
		return clientDAO.getClientById(pId);
	}
	
}
