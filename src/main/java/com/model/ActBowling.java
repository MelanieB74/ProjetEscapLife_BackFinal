package com.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe pour declarer l'activite type Bowling (@DicriminatorValue). 
 * Elle herite de la classe Activite par le Single_Table.
 */

@DiscriminatorValue("bowling")

@Entity
public class ActBowling extends Activite {

	// ===================== ATTRIBUTS =====================
	@Column(name="num_piste")
	private int piste;
	
	
	// ===================== CONSTRUCTEURS =====================
	public ActBowling() {
		super();
	}

	public ActBowling(float tarifEtudiant, float tarifNormal, float tarifJeune, float tarifEntreprise, int nbMax,
			int nbMin, int piste, String description) {
		super(tarifEtudiant, tarifNormal, tarifJeune, tarifEntreprise, nbMax, nbMin, description);
		this.piste = piste;
	}

	// ===================== GETTERS ET SETTERS =====================
	public int getPiste() {
		return piste;
	}
	public void setPiste(int piste) {
		this.piste = piste;
	}

}
