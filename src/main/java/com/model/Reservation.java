package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Classe pour declarer les reservations du centre de loisirs. Cette classe permet de
* creer la table "reservation_infos" dans la base de donnee par @Entity et @Table.
* Elle permettra au client de faire une reservation directement sur le site web du
* centre de loisirs.Elle permmettra aussi aux employes de les consulter et au
* responsable de les gerer.
*/

@Entity
@Table(name="reservation_infos")
public class Reservation {
	
	 /**
     * l'id est une primary key et est auto-increment.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="date_jour")
    private String date;
    
    private String heure;
    
  
    
    /**
     * Jointure avec la table Activite (via id_activite) pour pouvoir affecter
     * joindre la reservation a une activite.
     *Relation ManyToOne : 1,* reservations peuvent contenir 1 activite.
     */
    @ManyToOne
    @JoinColumn(name="id_activite")
    private Activite activite;
    
    /**
     * Jointure avec la table Client (via id_person) pour pouvoir affecter
     * joindre la reservation a un client.
     *Relation ManyToOne : 1,* reservations peuvent contenir 1 activite.
     */
    @ManyToOne
    @JoinColumn(name="id_client")
    private Client client;
    
    public Reservation() {
        super();
    }
    
    /**
     * Constructeur avec les variables de cette classe (sauf l'id car auto-increment)
     */
    public Reservation(String date, String heure, Activite activite, Client client) {
        this.date = date;
        this.heure = heure;
        this.activite = activite;
        this.client = client;
    }


	public int getId() {
	    return id;
	}
	public void setId(int id) {
	    this.id = id;
	}
	
	public String getDate() {
	    return date;
	}
	public void setDate(String date) {
	    this.date = date;
	}
	
	public String getHeure() {
	    return heure;
	}
	public void setHeure(String heure) {
	    this.heure = heure;
	}

	public Activite getActivite() {
		return activite;
	}
	
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	
	public Client getClient() {
	    return client;
	}
	public void setClient(Client client) {
	    this.client = client;
	}

}