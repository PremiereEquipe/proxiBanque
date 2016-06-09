package com.adaming.proxiBanqueSI.dao;

import com.adaming.proxiBanqueSI.model.Compte;

public interface ICompteDao {

	public boolean virement (Compte compte1, Compte compte2, double montant);
}
