package com.adaming.proxiBanqueSI.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.model.Compte;
import com.adaming.proxiBanqueSI.service.IBanqueService;

@ManagedBean(name="beanBanque")
@RequestScoped
public class BeanBanque {

	private static final long SerialVersionUID = 1L;
	
	@Autowired
	private IBanqueService banqueService;
	
	/**
	 * Récupération de la liste des clients du conseiller clientèle.
	 * @return
	 */
	public List<Client> getListeClients(){
		return banqueService.getAllClients();
	}
	
	/**
	 * Ajout d'un client.
	 * @param pClient
	 */
	public void ajouterClient (Client pClient) {
		banqueService.addClient(pClient);
	}
	
	/**
	 * Récupération d'un client par son identifiant.
	 * @param pId
	 * @return
	 */
	public Client recupererClient (int pId) {
		banqueService.getClientById(pId);
	}
	
	public boolean virement (Compte compte1, Compte compte2, double montant) {
		
		double nouveauSoldeCompte1 = compte1.getSolde() - montant;
		double decouvertMax = 
		
		if ()
			return false;
		else {
			banqueService.debiter(compte1, montant);
			banqueService.crediter(compte2, montant);
			return true;
		}
			
		
		
	}
}
