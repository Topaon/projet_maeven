package crud;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import util.MaConnexion;

class StagiaireServiceTest {
	
	StagiaireService ss = new StagiaireService();
	private Connection con;
	private final String URL_H2 = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

	@Test
	void testGetAllStagiaires() {
		try {
			String req = "SELECT * FROM stagiaire";
			Connection con = DriverManager.getConnection("URL_H2", "root", "" );
			PreparedStatement stmt = con.prepareStatement(req);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testAjouterStagiaire() {
		String req = "CREATE TABLE IF NOT EXISTS stagiaire (\r\n"
				+ "    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,\r\n"
				+ "    prenom VARCHAR(50) NOT NULL,\r\n"
				+ "    mdp VARCHAR(50) NOT NULL,\r\n"
				+ "    email VARCHAR(50) NOT NULL,\r\n"
				+ "    ddn DATE NOT NULL)";
		Connection con;
		try {
			con = DriverManager.getConnection("URL_H2", "root", "" );
			PreparedStatement stmt = con.prepareStatement(req);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testSupprimerStagiaire() {
		fail("Not yet implemented");
	}

}
