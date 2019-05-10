package com.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe pour declarer l'activite type Escape Game (@DicriminatorValue). 
 * Elle herite de la classe Activite par le Single_Table.
 */

@DiscriminatorValue("escapeGame")

@Entity
public class ActEscapeGame extends Activite {

	// ===================== ATTRIBUTS =====================
	private String mission;

	
	// ===================== CONSTRUCTEURS =====================
	public ActEscapeGame() {
		super();
	}

	/**
	 * Constructeur contenant les variables de la classe mere Activite et celui de cette classe.
	 */
	public ActEscapeGame(float tarifEtudiant, float tarifNormal, float tarifJeune, float tarifEntreprise, int nbMax,
			int nbMin, String mission, String description) {
		super(tarifEtudiant, tarifNormal, tarifJeune, tarifEntreprise, nbMax, nbMin, description);
		this.mission = mission;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}

}
