package com.inetum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionAutoClosable {

	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://localhost:3306/inetum_db";
	static final String USER = "root";
	static final String PASSWORD = "";
	
	public static void main(String[] args) {
		try {
			Class.forName(DRIVER);
			System.out.println("Driver ok");
			
			// try with ressources
			try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)){
				System.out.println("Connexion ok");
			} catch (SQLException e) {
				System.out.println("Connexion nok");
			};
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nok");
		}
	}
}
