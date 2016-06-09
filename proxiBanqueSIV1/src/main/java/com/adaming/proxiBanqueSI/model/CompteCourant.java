package com.adaming.proxiBanqueSI.model;

import javax.persistence.Column;

/**
 * Compte Courant, non remunere
 * @author INTI-0213
 *
 */
public class CompteCourant extends Compte {

	private static final long serialVersionUID = 1L;
	
	@Column(name="type")
	private String type;
	
	private double decouvertAutorise;
	
	public CompteCourant() {
		super();
		decouvertAutorise = -500;
		type = "courant";
	}
	
	
	/**
	 * Debite le compte si le solde reste au dessus du decouvert authorise.
	 */
	@Override
	public boolean debiterSolde(double montant) {
		double soldePotentiel = getSolde() - montant;
		if (soldePotentiel >= decouvertAutorise){
			setSolde(soldePotentiel);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * GETTERS and SETTERS
	 */
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAuthorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}
	
	
}
