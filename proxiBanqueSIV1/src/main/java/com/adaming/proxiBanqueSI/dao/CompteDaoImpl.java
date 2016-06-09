package com.adaming.proxiBanqueSI.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.proxiBanqueSI.model.Client;
import com.adaming.proxiBanqueSI.model.Compte;

@Repository
@Transactional
public class CompteDaoImpl implements ICompteDao {

	@Autowired // Injection automatique de la session factory
	private SessionFactory sessionFactory;
	
	/**
	 * Met a jour le solde du compte
	 */
	@Transactional(readOnly=false)
	public boolean updateCompte(int idCompte, double nouveauSolde) {
		System.out.println("====> DAO : update solde");
		
		Session session = sessionFactory.openSession();
		
		String hqlUpdate = "UPDATE Compte SET "
				+ " solde = :cSolde " 
				+ " WHERE id= :cID";
		Query query = session.createQuery(hqlUpdate);
		query.setParameter("cSolde", nouveauSolde);
		query.setParameter("cID", idCompte);
		
		int result = query.executeUpdate();
		System.out.println("====> DAO update compte : " + result);
		
		return true;
	}

	/**
	 * A partir du numero de compte, 
	 * Retourne le compte
	 */
	@Transactional(readOnly=true)
	public Compte getCompteByNum(String numCompte) {
		System.out.println("====> DAO : get compte numero : " + numCompte);
		
		Session session = sessionFactory.openSession();

		String hqlReq = "FROM Compte WHERE numero_compte= :cNum";
		Query query = session.createQuery(hqlReq);
		query.setParameter("cNum", numCompte);
		@SuppressWarnings ("unchecked")
		List<Compte> compteList = query.list();
		
		return compteList.get(0);
	}

	/**
	 * A partir de l'id du compte, 
	 * Retourne le compte
	 */
	@Transactional(readOnly=true)
	public Compte getCompteById(int idCompte) {
		System.out.println("====> DAO : get compte id#" + idCompte);
		
		Session session = sessionFactory.openSession();

		String hqlReq = "FROM Compte WHERE id= :cID";
		Query query = session.createQuery(hqlReq);
		query.setParameter("cID", idCompte);
		@SuppressWarnings ("unchecked")
		List<Compte> compteList = query.list();
		
		return compteList.get(0);
	}


}
