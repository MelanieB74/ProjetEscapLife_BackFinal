package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ActLaserGame;

/**
 * Classe instanciee comme Dao avec @Repository. 
 * Les differentes methodes concernant le client y sont declarees : 
 * elle herite de la classe JpaRepository qui contient les methodes par defaut 
 * que l'application utilisera : 
 * save (pour l'ajout d'une activite), 
 * update (pour modifier une activite), 
 * delete (pour supprimer une activite) et 
 * getAll (pour consulter la liste des activites contenues dans la base de donnees).
 */

@Repository
public interface IActLaserGameDao extends JpaRepository<ActLaserGame, Integer> {
	
	/**
	 * findById permet de rechercher une activite via son id.
	 */
	public ActLaserGame findById(int id);
	
	/**
	 * findByTheme permet de rechercher une activite via le theme de la salle.
	 */
	public ActLaserGame findByTheme(String theme);
}
