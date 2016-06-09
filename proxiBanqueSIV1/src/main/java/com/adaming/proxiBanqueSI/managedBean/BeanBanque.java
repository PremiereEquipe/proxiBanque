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
	List<Client> listeClients=null;
	
	private Client client;
	
	/**
	 * R�cup�ration de la liste des clients du conseiller client�le.
	 * @return
	 */
	public List<Client> getListeClients(){
		System.out.println("===== Entr�e dans la m�thode getListeClients de BeanBanque.java. =====");
		listeClients=banqueService.getAllClients();
		System.out.println("===== Entr�e dans la m�thode getListeClients de BeanBanque.java. =====");
		return listeClients;
	}
	
	/**
	 * Ajout d'un client.
	 * @param pClient
	 */
	public void ajouterClient (Client pClient) {
		banqueService.addClient(pClient);
	}
	
	/**
	 * Creer un nouveau client
	 */
	public void initClient(){
		client = new Client();
	}
	
	/**
	 * R�cup�ration d'un client par son identifiant.
	 * @param pId
	 * @return
	 */
//	public Client recupererClient (int pId) {
//		banqueService.getClientById(pId);
//	}
	
	public boolean virement (Compte compte1, Compte compte2, double montant) {
		return banqueService.virement(compte1, compte2, montant);
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	
	
}
