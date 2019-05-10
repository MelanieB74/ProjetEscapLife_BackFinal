package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe permettant de declarer et affecter les differents roles aux
 * utilisateurs de l'application. Cette classe permet de creer la table "roles"
 * dans la base de donnée par @Entity et @Table.
 * 
 */

@Entity
@Table(name = "roles")
public class Role {

	// ===================== ATTRIBUTS =====================
	/**
	 * l'id est une primary key et est auto-increment.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * variable permettant de declarer le role de l'utilisateur.
	 */
	private String roleName;

	/**
	 * Jointure avec la table Utilisateur (via id_utilisateur) pour affecter un
	 * ou plusieurs role a l'utilisateur afin qu'il puisse accéder aux services
	 * lui correspondant. Relation ManyToOne : 1,* role affecter a 1
	 * utilisateur.
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id_utilisateur")
	private Utilisateur utilisateur;

	
	// ===================== CONSTRUCTEURS =====================
	public Role() {
		super();
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(String roleName, Utilisateur utilisateur) {
		super();
		this.roleName = roleName;
		this.utilisateur = utilisateur;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
