package com.inetum.jdbc;

import java.sql.*;

public class TestConnexion {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			// Initialise la classe Driver du package com.mysql.cj.jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver ok");
			
			// Etablissement de la connexion
			final String url = "jdbc:mysql://localhost:3306/inetum_db";
			final String user = "root";
			final String password = "";
			
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connexion réussie");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver nok");
			
		} catch (SQLException e) {
			System.out.println("Echec de la connexion");
		} finally {
			// Fermeture de la connexion après usage, quoi qu'il arrive
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
