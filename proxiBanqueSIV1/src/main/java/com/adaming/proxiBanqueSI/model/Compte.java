package com.adaming.proxiBanqueSI.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe abstraite de tous les types de compte.
 * @author INTI-0213
 *
 */
@Entity(name="compte")
@Table(name="comptes")
public abstract class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compte", nullable=false)
	private int id;
	
	@Column(name="numero_compte")
	private int numCompte;
	
	@Column(name="solde")
	private double solde;
	
	@Column(name="date_ouverture")
	private Date dateOuverture;
	
	public boolean crediterSolde(double montant){
		solde += montant;
		return true;
	}
	
	public abstract boolean debiterSolde(double montant);
	
	/***************************************
	 * Constructors
	 */
	public Comptes() {
		
	}
	public Comptes(int numCompte, double solde, Date dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}
	public Comptes(int id, int numCompte, double solde, Date dateOuverture) {
		super();
		this.id = id;
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}
	
	/****************************************
	 * GETTERS and SETTERS
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumCompte() {
		return numCompte;
	}
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateOuverture() {
		return dateOuverture;
	}
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	/**
	 * Shows the content of the account
	 */
	@Override
	public String toString() {
		return "Comptes [id=" + id + ", numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + "]";
	}

	
	
}
