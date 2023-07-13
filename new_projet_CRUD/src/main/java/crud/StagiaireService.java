package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.MaConnexion;

public class StagiaireService implements InterfaceStagiaireUtil {

	public ArrayList<Stagiaire> getAllStagiaires() {
		ArrayList<Stagiaire> listStagiaires = new ArrayList<Stagiaire>();
		Connection con = MaConnexion.getInstance().getConnection();
		String rq ="SELECT * FROM stagiaire";
		try {
			PreparedStatement st = con.prepareStatement(rq);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Stagiaire sta = new Stagiaire(rs.getInt("id"), rs.getString("prenom"), rs.getString("mdp"), rs.getString("email"), rs.getString("ddn"));
				listStagiaires.add(sta);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listStagiaires;
	}
	
	public void ajouterStagiaire(Stagiaire s) {
		String req = "INSERT INTO stagiaire VALUES (null, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = MaConnexion.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(req);
			
			stmt.setString(1, s.getPrenom());
			stmt.setString(2, s.getMdp());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getDdn().toString());
			stmt.setString(5, s.getPhoto());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifierStagiaire(Stagiaire s) {
		String req = "UPDATE stagiaire SET prenom = ?, mdp = ?, email = ?, ddn = ? WHERE id = ?";
		Connection con = MaConnexion.getInstance().getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement(req);
			
			stmt.setString(1, s.getPrenom());
			stmt.setString(2, s.getMdp());
			stmt.setString(3, s.getEmail());
			stmt.setString(4, s.getDdn());
			stmt.setInt(4, s.getId());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerStagiaire(int id) {
		String req = "DELETE FROM stagiaire WHERE id = ?";
		try {
			Connection con = MaConnexion.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(req);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
