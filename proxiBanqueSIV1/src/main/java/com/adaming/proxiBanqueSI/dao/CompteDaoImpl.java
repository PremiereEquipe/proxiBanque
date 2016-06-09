package com.adaming.proxiBanqueSI.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	public boolean updateCompte(int idCompte, double montant) {
		
		System.out.println("====> DAO : update solde");
		
		Session session = sessionFactory.openSession();
		
		String hqlUpdate = "IPDATE Client SET "
				+ " nom = :cNom, "
				+ " prenom = :cPrenom, "
				+ " adresse= :cAdresse, "
				+ " code_postal= :cCodePosta, "
				+ "	ville= :cVille, "
				+ " telephone= :cTelephone, "
				+ " liste_comptes= :cListeComptes " 
				+ " WHERE id= :cID";
		Query query = session.createQuery(hqlUpdate);
		query.setParameter("cNom", pClient.getNom());
		query.setParameter("cPrenom", pClient.getPrenom());
		query.setParameter("cAdresse", pClient.getAdresse());
		query.setParameter("cCodePosta", pClient.getCodePostal());
		query.setParameter("cVille", pClient.getVille());
		query.setParameter("cTelephone", pClient.getTelephone());
		query.setParameter("cListeComptes", pClient.getListeComptes());
		query.setParameter("cID", pClient.getId());
		
		query.executeUpdate();
		
		return false;
	}

	/**
	 * A partir du numero de compte, 
	 * Retourne le compte
	 */
	@Transactional(readOnly=true)
	public Compte getCompteByNum(String numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * A partir de l'id du compte, 
	 * Retourne le compte
	 */
	@Transactional(readOnly=true)
	public Compte getCompteById(int idCompte) {
		// TODO Auto-generated method stub
		return null;
	}


}
