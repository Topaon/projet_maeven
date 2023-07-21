package com.inetum.dao;

import java.util.List;

import com.inetum.entity.Employe;

public interface InterfaceDaoEmploye {
	/**
	 * Renvoie l'employé correspondant à l'id passé en paramètre
	 * @param id L'id de l'employée à récupérer
	 * @return un objet Employe
	 */
	Employe findById(Integer id);
	
	/**
	 * Renvoie un objet List contenant tous les employés de la base de données
	 * @return
	 */
	List<Employe> findAll();
	
	/**
	 * Ajoute l'employé passé en paramètre à la base de données
	 * @param e
	 * @return 
	 */
	Employe insertEmploye(Employe e);
	
	/**
	 * Modifie l'employé passé en paramètre dans la base de données
	 * @param e
	 */
	void updateEmploye(Employe e);
	
	/**
	 * Supprimme de la base de données l'employé passé en paramètre
	 * @param id
	 */
	void deleteEmployeById(Integer id);
	
	/**
	 * Renvoie la liste des employes ayant le nom passé en paramètre
	 * @return
	 */
	List<Employe> findByPrenom(String pre);
}
