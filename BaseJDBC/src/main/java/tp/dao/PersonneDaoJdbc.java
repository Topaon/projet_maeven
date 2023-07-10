package tp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import tp.entity.Personne;

public class PersonneDaoJdbc implements PersonneDao {
	
	public Connection connect() {
		Connection cn = null;
		
		try {
			ResourceBundle ressources = ResourceBundle.getBundle("paramDB"); // paramDB.properties
			String driver = ressources.getString("driver");
			String chUrl = ressources.getString("url");
			String username = ressources.getString("username");
			String password = ressources.getString("password");
			Class.forName(driver);
			cn = DriverManager.getConnection(chUrl,username,password) ;
		} catch (ClassNotFoundException e) {
			System.err.println("Le driver JDBC ne peut pas être chargé en mémoire, erreur de nom ou dans pom.xml");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}

	@Override
	public Personne createPersonne(Personne p) {
		try(Connection cn = this.connect()) {
		// Création d'une connection (initialisation du driver)
			// Création du Statement et envoi de la requète SQL			
			PreparedStatement pst = cn.prepareStatement("INSERT INTO Personne(prenom, nom) VALUES(?,?)");
			pst.setString(1, p.getPrenom());
			pst.setString(2, p.getNom());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Personne searchPersonneById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> searchAllPersonne() {
		List<Personne> l = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = this.connect()) {
			Statement st = cn.createStatement();
			String rsql = "SELECT * FROM Personne";
			rs = st.executeQuery(rsql);
			
			while(rs.next()) {
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				Integer id = rs.getInt("id");
				Personne p = new Personne(id, prenom, nom);
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void updatePersonne(Personne p) {
		try(Connection cn = this.connect()) {
			Statement st = cn.createStatement();
			String rsql = "UPDATE Personne SET nom = 'Vinsmoke' WHERE prenom = 'Sanji'";
			st.executeUpdate(rsql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletePersonne(Integer id) {
		// TODO Auto-generated method stub

	}

}
