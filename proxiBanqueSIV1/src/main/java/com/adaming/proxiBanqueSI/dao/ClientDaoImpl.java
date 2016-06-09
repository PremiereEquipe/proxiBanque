package com.adaming.proxiBanqueSI.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.proxiBanqueSI.model.Client;

<<<<<<< HEAD


=======
>>>>>>> branch 'master' of https://github.com/PremiereEquipe/proxiBanque.git

@Repository
@Transactional
public class ClientDaoImpl implements IClientDao {

	@Autowired // Injection automatique de la session factory
	private SessionFactory sessionFactory;

	/**
	 * Setter pour injection
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly=false)
	public void addClient(Client client) {
		Session session = sessionFactory.openSession();
		session.save(client);
	}
	
	@Transactional(readOnly = true)
	public List<Client> getAllClient() {
		Session session = sessionFactory.openSession();
		
		
		String hqlAllReq = "FROM Client";
		Query query = session.createQuery(hqlAllReq);
		
		// Pagination
		//query.setFirstResult(1);
		//query.setMaxResults(3);
		
		@SuppressWarnings ("unchecked")
		List<Client> clientList = query.list();
		
		return clientList;
	}

	public void updateClient(Client pClient) {
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
		
//		int result = query.executeUpdate();
//		System.out.println("Nombre d'employe MAJ : =================> " + result);
		
	}

	public void deleteClient(Client pClient) {
		Session session = sessionFactory.openSession();
//		session.delete(pClient);
		
		String hqlDelete = "DELETE FROM Client c WHERE c.id= :cID";
		
		Query query = session.createQuery(hqlDelete);
		query.setParameter("cID",pClient.getId());
		query.executeUpdate();
		
		//int result = query.executeUpdate();
		//System.out.println("Nombre de Clients supprimes : =================> " + result);
				
	}

	public Client getClientById(int idClient) {
		Session session = sessionFactory.openSession();

		String hqlReq = "FROM Employe WHERE id= :employeID";
		Query query = session.createQuery(hqlReq);
		query.setParameter("employeID", idClient);
		@SuppressWarnings ("unchecked")
		List<Client> clientList = query.list();
		
		return clientList.get(0);
	}
	

		
}
