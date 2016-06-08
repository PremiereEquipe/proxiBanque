package com.adaming.proxiBanqueSI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.dao.ClientDaoImpl;

public class BanqueServiceImpl implements IBanqueService{

	// injection auto du DAO
	@Autowired
	private ClientDaoImpl clientDAO;
	
	/**
	 * Return a list of all the clients in the DB.
	 */
	public List<Client> getAllClients() {
		
		return clientDAO.getAllClients();
	}

}
