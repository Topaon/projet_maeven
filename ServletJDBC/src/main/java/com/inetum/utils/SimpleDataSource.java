package com.inetum.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
/**
 * 
 * @author Simon
 *@version 0.0.1 du 07-07-2023
 */
public class SimpleDataSource {
	static String driver;
	static String url;
	static String user;
	static String password;
	
	
	/**
	 * 
	 * Initialiser les paramètres de connexion à une base de données
	 * 
	 * @param nomFicherProperties Le nom du fichier .properties contenant les informations de connexion à la basse de données
	 * @throws ClassNotFoundException Si la méthode forName ne trouve pas le driver passé en paramètre
	 */
	public static void init(String nomFicherProperties) throws ClassNotFoundException {
		ResourceBundle res = ResourceBundle.getBundle(nomFicherProperties);
		driver = res.getString("mysql.driver");
		url = res.getString("mysql.url");
		user = res.getString("mysql.user");
		password = res.getString("mysql.password");
		
		Class.forName(driver);
		System.out.println("Driver ok");
	}
	
	
	/**
	 * Permet une connexion à la base de donnée une fois les paramètres chargé avec init()
	 * @return la connexion java.sql
	 * @throws SQLException S'il y a un problème de connexion à la BDD
	 */
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
