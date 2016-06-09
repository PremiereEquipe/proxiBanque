package com.adaming.proxiBanqueSI.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.model.Compte;
import com.adaming.proxiBanqueSI.service.IBanqueService;

@ManagedBean(name="beanBanque")
@RequestScoped
public class BeanBanque implements Serializable{

	private static final long SerialVersionUID = 1L;
	
	@Autowired
	private IBanqueService banqueService;
	List<Client> listeClients=null;
	
	private Client client;
	
	public BeanBanque() {
		System.out.println("===> MB : constructor");
	}
	
	/**
	 * Récupération de la liste des clients du conseiller clientèle.
	 * @return
	 */
	public List<Client> getListeClients(){
		System.out.println("===> MB : getListeClients");
		listeClients=banqueService.getAllClients();
		System.out.println("===> MB : getListeClients, out");
		return listeClients;
	}
	
	/**
	 * Ajout d'un client.
	 * @param pClient
	 */
	public void ajouterClient (Client pClient) {
		System.out.println("===> MB : ajout client " + pClient);
		banqueService.addClient(pClient);
	}
	
	/**
	 * Creer un nouveau client
	 */
	public void initClient(){
		System.out.println("===> MB : init client");
		client = new Client();
	}
	
	/**
	 * Récupération d'un client par son identifiant.
	 * @param pId
	 * @return
	 */
//	public Client recupererClient (int pId) {
//		banqueService.getClientById(pId);
//	}
	
	public boolean virement (String numClientDebite, String numClientCredite, double montant) {
		return banqueService.virement(numClientDebite, numClientCredite, montant);
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	
	
	
}
