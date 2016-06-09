package com.adaming.proxiBanqueSI.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe abstraite de tous les types de compte.
 * @author INTI-0213
 *
 */
@Entity(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
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
	
    /*========================================================================*/
    /*======================== ASSOCIATIONS ==================================*/
    /*========================================================================*/
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName ="id_client")
    private Client client;
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
	
	/***************************************
	 * Constructors
	 */
	public Compte() {
		
	}
	public Compte(int numCompte, double solde, Date dateOuverture) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}
	public Compte(int id, int numCompte, double solde, Date dateOuverture) {
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
		return "Compte [id=" + id + ", numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture="
				+ dateOuverture + "]";
	}

	
	
}
