package com.adaming.proxiBanqueSI.dao;

import com.adaming.proxiBanqueSI.model.Compte;

public interface ICompteDao {

	public boolean updateCompte (int idCompte, double nouveauSolde);
	
	public Compte getCompteByNum (String numCompte);
	
	public Compte getCompteById (int idCompte);
}
