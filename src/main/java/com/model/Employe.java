package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.Inheritance;
//import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe pour déclarer les employés du centre de loisirs. Cette classe permet de
 * créer la table "employe_infos" dans la base de donnée par @Entity et @Table.
 * Elle hérite de la classe Personne.
 */

@Entity
@Table(name="employe_infos")
public class Employe extends Personne {
	
	
	// ===================== ATTRIBUTS =====================
	/**
	 * La variable "type" permet de différencier les employés selon l'activité gérée 
	 * et le responsable du centre de loirsirs.
	 */
	@Column(name="type_emp")
	private String type;
	
	private String prenom;
	
	private int matricule;
	
	
	// ===================== CONSTRUCTEURS =====================
	public Employe() {
		super();
	}

	public Employe(String type, String nom, String prenom, int matricule, long tel, String mail, String userName, String passWord) {
		super(nom, tel, mail, userName, passWord);
		this.type = type;
		this.prenom = prenom;
		this.matricule = matricule;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}	
	

}