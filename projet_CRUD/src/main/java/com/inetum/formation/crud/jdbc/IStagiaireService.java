package com.inetum.formation.crud.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface IStagiaireService {
	
	/**
	 * Renvoie la liste de tous les stagiaires présents dans la base de données
	 * @return
	 * @throws SQLException
	 */
	List<Stagiaire> allStagiaire() throws ClassNotFoundException, SQLException;
	
}
