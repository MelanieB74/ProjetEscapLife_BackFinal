package com.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Cette classe hérite de la classe Client (et donc de la Personne). Il s'agit
 * des clients moraux (ou entreprise).
 */

@DiscriminatorValue("entreprise")

@Entity
public class ClientEntreprise extends Client {
	
	
	// ===================== ATTRIBUTS =====================
	private long siret;

	
	// ===================== CONSTRUCTEURS =====================
	public ClientEntreprise() {
		super();
	}
	
	/**
	 * Constructeur avec les variables de cette classe et ceux de la classe Personne. La variable 
	 * statut de la classe Client n'y figure pas grace au constructeur 3 de la classe Client.
	 */
	public ClientEntreprise(String nom, long siret, long tel, String mail, String userName, String passWord, List<Reservation> reservations) {
		super(nom, tel, mail, userName, passWord, reservations);
		this.siret = siret;
	}

	
	// ===================== GETTERS ET SETTERS =====================
	public long getSiret() {
		return siret;
	}
	public void setSiret(long siret) {
		this.siret = siret;
	}

	
}