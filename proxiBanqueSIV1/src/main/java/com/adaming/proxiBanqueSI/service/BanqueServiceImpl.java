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
		
		return clientDAO.getAllClients();
	}

}
