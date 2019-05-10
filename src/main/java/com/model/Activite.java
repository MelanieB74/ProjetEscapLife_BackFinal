package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe pour declarer les activites du centre de loisirs. Cette classe permet de
 * creer la table "activite_infos" dans la base de donnee par @Entity et @Table.
 * L'Inheritance SINGLE_TABLE permet de faire heriter les autres classes activites
 * (ActBowling, ActCreche, ActEscapeGame, ActLAserGame) et de les rassembler dans 
 * cette meme table. Ces quatre activites sont differenciees dans la colonne "type_activ"
 * (declarer par le DiscrinimatorColumn) via le DiscriminatorValue.
 */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

@DiscriminatorColumn(name="type_activ", discriminatorType=DiscriminatorType.STRING)
@Entity
@Table(name="activite_infos")
public class Activite {
	
	
	// ===================== ATTRIBUTS =====================
	/**
	 * l'id est une primary key et est auto-increment.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_activite")
	private int id;
	
	private float tarifEtudiant;
	
	private float tarifNormal;

	private float tarifJeune;
	
	private float tarifEntreprise;
	
	@Column(name="nbMax_personnes")
	private int nbMax;
	
	@Column(name="nbMin_personnes")
	private int nbMin;
	
	private String description;
	
	/**
	 * Jointure avec la table Reservation (via id_activite) pour pouvoir affecter 
	 * une activite a une reservation. 
	 * Relation OneToMany : 1 activite appartient a 1,* reservation.
	 */
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, mappedBy="activite", fetch=FetchType.LAZY)
	List<Reservation> reservations = new ArrayList<Reservation>();
	
//	J'ai change le type de relation en One to Many car je pense que une activite peut contenir plusieurs reservation :
//	exemple : activite1 est reservee le 3 avril mais aussi le 5 mai par des clients differents.
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_activite")
//	Reservation reservation;
	
	
	// ===================== CONSTRUCTEURS =====================
	public Activite() {
		super();
	}

	/**
	 * Constructeur qui contient les variables de la classe pour ainsi pouvoir
	 * les utiliser dans les autres classes activites.
	 */
	public Activite(float tarifEtudiant, float tarifNormal, float tarifJeune, float tarifEntreprise, int nbMax,
			int nbMin, String description) {
		this.tarifEtudiant = tarifEtudiant;
		this.tarifNormal = tarifNormal;
		this.tarifJeune = tarifJeune;
		this.tarifEntreprise = tarifEntreprise;
		this.nbMax = nbMax;
		this.nbMin = nbMin;
		this.description = description;
	}

	/**
	 * Constructeur propore à la classe.
	 */
	public Activite(float tarifEtudiant, float tarifNormal, float tarifJeune, float tarifEntreprise, int nbMax,
			int nbMin, List<Reservation> reservations, String description) {
		this.tarifEtudiant = tarifEtudiant;
		this.tarifNormal = tarifNormal;
		this.tarifJeune = tarifJeune;
		this.tarifEntreprise = tarifEntreprise;
		this.nbMax = nbMax;
		this.nbMin = nbMin;
		this.reservations = reservations;
		this.description = description;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getNbMax() {
		return nbMax;
	}
	public void setNbMax(int nbMax) {
		this.nbMax = nbMax;
	}

	public int getNbMin() {
		return nbMin;
	}
	public void setNbMin(int nbMin) {
		this.nbMin = nbMin;
	}

	public float getTarifEtudiant() {
		return tarifEtudiant;
	}
	public void setTarifEtudiant(float tarifEtudiant) {
		this.tarifEtudiant = tarifEtudiant;
	}

	public float getTarifNormal() {
		return tarifNormal;
	}
	public void setTarifNormal(float tarifNormal) {
		this.tarifNormal = tarifNormal;
	}

	public float getTarifJeune() {
		return tarifJeune;
	}
	public void setTarifJeune(float tarifJeune) {
		this.tarifJeune = tarifJeune;
	}

	public float getTarifEntreprise() {
		return tarifEntreprise;
	}
	public void setTarifEntreprise(float tarifEntreprise) {
		this.tarifEntreprise = tarifEntreprise;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

//	Getter pour la relation OneToOne
//	public Reservation getReservation() {
//		return reservation;
//	}
//	public void setReservation(Reservation reservation) {
//		this.reservation = reservation;
//	}

	
}