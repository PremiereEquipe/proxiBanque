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
		System.out.println("===== Entrée dans la méthode getAllClients de BanqueServiceImpl.java. =====");
		return clientDAO.getAllClient();
	}

	public void addClient (Client pClient) {
		clientDAO.addClient(pClient);
	}
	
	/**
	 * Récupération d'un client par son identifiant.
	 * @param pId
	 * @return
	 */
	public Client getClientById (int pId) {
		return clientDAO.getClientById(pId);
	}

	/**
	 * Virement. Renvoie vrai s'il s'est bien passé, faux sinon.
	 */
	public boolean virement(String numClientDebite, String numClientCredite, double montant) {
		//clientDAO.updateClient(pClient);
		System.out.println("====> Service : methode virement a faire");
		return false;
	}
	
}
