package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Client;

/**
 * Classe instanciee comme Dao avec @Repository. 
 * Les differentes methodes concernant le client y sont declarees : 
 * elle herite de la classe JpaRepository qui contient les methodes par defaut 
 * que l'application utilisera : 
 * save (pour l'ajout d'un client), 
 * update (pour modifier un client), 
 * delete (pour supprimer un client) et 
 * getAll (pour consulter la liste des clients contenus dans la base de donnees).
 */

@Repository
public interface IClientDao extends JpaRepository<Client, Integer> {

	/**
	 * findById permet de rechercher un client via son id.
	 */
	public Client findById(int id);

	/**
	 * findByNom permet de rechercher un client via son nom.
	 */
	public Client findByNom(String nom);

}
