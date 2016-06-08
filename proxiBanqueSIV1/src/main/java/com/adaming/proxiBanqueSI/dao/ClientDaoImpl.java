package com.adaming.proxiBanqueSI.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.proxiBanqueSI.model.Client;

import fr.adaming.bo.Employe;



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
	

		
}
