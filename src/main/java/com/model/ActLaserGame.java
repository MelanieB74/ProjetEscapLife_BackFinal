package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe pour declarer l'activite type Laser Game (@DicriminatorValue). 
 * Elle herite de la classe Activite par le Single_Table.
 */

@DiscriminatorValue("laserGame")

@Entity
public class ActLaserGame extends Activite {

	// ===================== ATTRIBUTS =====================
	private String theme;
	
//	@Column(name = "nom_salle")
//	private int nomSalle;

	
	// ===================== CONSTRUCTEURS =====================
	public ActLaserGame() {
		super();
	}

	/**
	 * Constructeur contenant les variables de la classe mere Activite et celui
	 * de cette classe.
	 */
	public ActLaserGame(float tarifEtudiant, float tarifNormal, float tarifJeune, float tarifEntreprise, int nbMax,
			int nbMin, String theme, String description) {
		super(tarifEtudiant, tarifNormal, tarifJeune, tarifEntreprise, nbMax, nbMin, description);
		this.theme = theme;
	}

	
	// ===================== GETTERS ET SETTERS =====================
//	public int getNomSalle() {
//		return nomSalle;
//	}
//
//	public void setNomSalle(int nomSalle) {
//		this.nomSalle = nomSalle;
//	}

	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}

}
