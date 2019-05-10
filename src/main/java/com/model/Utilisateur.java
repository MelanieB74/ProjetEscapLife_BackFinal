package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe qui permettre aux clients et aux employes de s'authentifier via leur
 * login et leur mot de passe. Cette classe permet aussi de joindre
 * l'utilisateur a un ou plusieurs roles.
 */

@Entity
public class Utilisateur {

	// ===================== ATTRIBUTS =====================
	/**
	 * l'id est une primary key et est auto-increment.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int id;

	/**
	 * variables permettant l'authentification de l'utilisateur.
	 */
	@Column(name = "login")
	private String userName;

	@Column(name = "motDePasse")
	private String passWord;

	@Column(name = "cpt_active")
	private boolean actived;
	
//	/**
//	 * Jointure avec la table Client pour affecter un login et un mot de passe
//	 * au client afin qu'il puisse acceder aux services clients uniquement de
//	 * l'application. Relation OneToOne : 1 client ne peut avoir qu'un login et
//	 * un mot de passe.
//	 */
//	@OneToOne(mappedBy = "utilisateur")
//	private Client client;
	
	/**
	 * Jointure avec la table Employe pour affecter un login et un mot de passe
	 * à l'employe afin qu'il puisse acceder aux différents services de l'application. 
	 * Relation OneToOne : 1 client ne peut avoir qu'un login et un mot de passe.
	 */
//	@JsonIgnore
//	@OneToOne
//	private Employe employe;
	
	@JsonIgnore
	@ManyToOne
	private Employe employe;

	/**
	 * Jointure avec la table Role pour affecter un ou plusieurs roles a
	 * l'utilisateur (clients et employes). Relation OneToMany : 1 utilisateur
	 * contient 1,* role.
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "utilisateur")
	private List<Role> roles;

	
	// ===================== CONSTRUCTEURS =====================
	public Utilisateur() {
		super();
	}

	public Utilisateur(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
//	public Utilisateur(String userName, String passWord, Client client) {
//		super();
//		this.userName = userName;
//		this.passWord = passWord;
//		this.client = client;
//	}

	public Utilisateur(String userName, String passWord, Employe employe) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.employe = employe;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
//	public Client getClient() {
//		return client;
//	}
//	public void setClient(Client client) {
//		this.client = client;
//	}

	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

}
