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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(rq);
			rs = st.executeQuery();
			while(rs.next()) {
				Stagiaire sta = new Stagiaire(rs.getInt("id"), rs.getString("prenom"), rs.getString("email"), rs.getDate("ddn"), rs.getString("mdp"));
				listStagiaires.add(sta);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listStagiaires;
	}
	
	public String getFirstName() {
		String name = "";
		Connection con = MaConnexion.getInstance().getConnection();
		String rq ="SELECT * FROM stagiaire WHERE id=1";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(rq);
			name = rs.getString("prenom");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
