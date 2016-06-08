package com.adaming.proxiBanqueSI;

/**
 * Compte d'epargne
 * @author INTI-0213
 *
 */
public class CompteEpargne extends Compte {
	
	private double soldeMinimum;
	
	private double tauxRenumeration;
	
	/**
	 * Constructor
	 */
	public CompteEpargne() {
		super();
		soldeMinimum = 0;
		tauxRenumeration = 0.3;
	}
	
	/**
	 * Debite le compte si le solde reste au dessus du minimum.
	 */
	@Override
	public boolean debiterSolde(double montant) {
		double soldePotentiel = getSolde() - montant;
		if (soldePotentiel >= soldeMinimum){
			setSolde(soldePotentiel);
			return true;
		} else {
			return false;
		}
	}

	/**********************************************
	 * GETTERS and SETTERS
	 */
	public double getSoldeMinimum() {
		return soldeMinimum;
	}

	public void setSoldeMinimum(double soldeMinimum) {
		this.soldeMinimum = soldeMinimum;
	}

	public double getTauxRenumeration() {
		return tauxRenumeration;
	}

	public void setTauxRenumeration(double tauxRenumeration) {
		this.tauxRenumeration = tauxRenumeration;
	}
	
	
}
