package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Employe;

/**
 * Classe instanciee comme Dao avec @Repository. 
 * Les differentes methodes concernant l'employe y sont declarees : 
 * elle herite de la classe JpaRepository qui contient les methodes par defaut 
 * que l'application utilisera : 
 * save (pour l'ajout d'un employe), 
 * update (pour modifier un employe), 
 * delete (pour supprimer un employe) et 
 * getAll (pour consulter la liste des employes contenus dans la base de donnees).
 */

public interface IEmployeDao extends JpaRepository<Employe, Integer> {

	/**
	 * findById permet de rechercher un employe via son id.
	 */
	public Employe findById(int id);

	/**
	 * findByNom permet de rechercher un employe via son nom.
	 */
	public Employe findByNom(String nom);

}
