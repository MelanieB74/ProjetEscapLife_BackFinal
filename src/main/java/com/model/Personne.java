package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe pour déclarer les attributs en commun avec toutes les personnes de
 * l'aplication (id, nom, telephone et mail). @MappedSuperclass permet de
 * déclarer cette classe mais elle ne créera pas de table dans la base de donnée. 
 * Autrement dit, elle permet d'utiliser les varaibles dans d'autres classes : 
 * Client, ClientEntreprise, Employe.
 */

@MappedSuperclass
public class Personne {
	
	
	// ===================== ATTRIBUTS =====================
	/**
	 * l'id est une primary key et est auto-incrément.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pers")
	private int id;
	
	@Column(length=20)
	private String nom;
	
	@Column(name="telephone")
	private long tel;
	
	@Column(name="email")
	private String mail;
	
	/**
	 * variables permettant l'authentification de l'utilisateur.
	 */
	@Column(name = "login")
	private String userName;

	@Column(name = "motDePasse")
	private String passWord;

//	@Column(name = "cpt_active")
//	private boolean actived;
	
	/**
	 * Jointure avec la table Role pour affecter un ou plusieurs roles a
	 * l'utilisateur (clients et employes). Relation OneToMany : 1 utilisateur
	 * contient 1,* role.
	 */
//	@JsonIgnore
//	@OneToMany(mappedBy = "personne")
//	private List<Role> roles;
		
	
	// ===================== CONSTRUCTEURS =====================
	public Personne() {
		super();
	}

	public Personne(int id, String nom, long tel, String mail, String userName, String passWord) {
		super();
		this.id = id;
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.userName = userName;
		this.passWord = passWord;
	}

	public Personne(String nom, long tel, String mail, String userName, String passWord) {
		super();
		this.nom = nom;
		this.tel = tel;
		this.mail = mail;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	// ===================== GETTERS ET SETTERS =====================
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

	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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

//	public boolean isActived() {
//		return actived;
//	}
//	public void setActived(boolean actived) {
//		this.actived = actived;
//	}
	
//	public List<Role> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}

	
}
