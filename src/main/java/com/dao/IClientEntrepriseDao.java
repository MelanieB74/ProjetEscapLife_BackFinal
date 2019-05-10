package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ClientEntreprise;

/**
 * Classe instanciee comme Dao avec @Repository. 
 * Les differentes methodes concernant le clientEntreprise y sont declarees : 
 * elle herite de la classe JpaRepository qui contient les methodes par defaut 
 * que l'application utilisera : 
 * save (pour l'ajout d'un clientEntreprise), 
 * update (pour modifier un clientEntreprise), 
 * delete (pour supprimer un clientEntreprise) et 
 * getAll (pour consulter la liste des clientsEntreprises contenus dans la base de donnees).
 */

public interface IClientEntrepriseDao extends JpaRepository<ClientEntreprise, Integer> {

	/**
	 * findById permet de rechercher un clientEntreprise via son id.
	 */
	public ClientEntreprise findById(int id);

	/**
	 * findByNom permet de rechercher un clientEntreprise via son nom.
	 */
	public ClientEntreprise findByNom(String nom);

}
