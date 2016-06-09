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
	
	private double decouvertAuthorise;
	
	public CompteCourant() {
		super();
		decouvertAuthorise = -500;
		type = "courant";
	}
	
	
	/**
	 * Debite le compte si le solde reste au dessus du decouvert authorise.
	 */
	@Override
	public boolean debiterSolde(double montant) {
		double soldePotentiel = getSolde() - montant;
		if (soldePotentiel >= decouvertAuthorise){
			setSolde(soldePotentiel);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * GETTERS and SETTERS
	 */
	public double getDecouvertAuthorise() {
		return decouvertAuthorise;
	}

	public void setDecouvertAuthorise(double decouvertAuthorise) {
		this.decouvertAuthorise = decouvertAuthorise;
	}
	
	
}
