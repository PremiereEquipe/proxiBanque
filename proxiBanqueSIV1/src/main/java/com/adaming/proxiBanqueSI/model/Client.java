package com.adaming.proxiBanqueSI.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="Client")
@Table(name="clients")
public class Client {
	
	
	/* Param�tres. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client", nullable = false)
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "code_postal")
	private int codePostal;
	@Column(name = "ville")
	private String ville;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "liste_comptes")
	private List<Compte> listeComptes;
	
    /*========================================================================*/
    /*======================== ASSOCIATIONS ==================================*/
    /*========================================================================*/
    @OneToOne
    @JoinColumn(name = "compte_id", referencedColumnName ="id_compte")
    private Compte compte;
    
    public Compte getCompte() {
        return compte;
    }
    
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    
	
	/* Constructeurs. */
	public Client() {
		super();
	}
	public Client(String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
			List<Compte> listeComptes) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.listeComptes = listeComptes;
	}
	public Client(int id, String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
			List<Compte> listeComptes) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.listeComptes = listeComptes;
	}
	

	/* Accesseurs et mutateurs. */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Compte> getListeComptes() {
		return listeComptes;
	}
	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}
}
