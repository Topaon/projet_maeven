package com.inetum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionSecure {
	
	static ResourceBundle res = ResourceBundle.getBundle("JDBC_Ressources");

	static String driver = res.getString("mysql.driver");
	static String url = res.getString("mysql.url");
	static String user = res.getString("mysql.user");
	static String password = res.getString("mysql.password");
	
	public static void main(String[] args) { 
		System.out.println(driver);
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		try {
			Class.forName(driver);
			System.out.println("Driver ok");
			
			// try with ressources
			try(Connection con = DriverManager.getConnection(url, user, password)){
				System.out.println("Connexion ok");
				System.out.println("Requète executée");
			} catch (SQLException e) {
				System.out.println("Connexion nok");
			};
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nok");
		}
		
		
	}
}
