package com.inetum.formation.crud.jdbc.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inetum.formation.crud.jdbc.IStagiaireService;
import com.inetum.formation.crud.jdbc.Stagiaire;
import com.inetum.jdbc.MaConnexion;


public class StagiaireService implements IStagiaireService {

	@Override
	public List<Stagiaire> allStagiaire() throws ClassNotFoundException, SQLException {
		List<Stagiaire> stg = new ArrayList<>();
		
		String req = "SELECT * FROM stagiaire";
		Connection con = MaConnexion.getInstance().getConnection(); // <-- Cette ligne de code fait tout planter, mais que quand on lance le projet sur un serveur
		PreparedStatement stmt = con.prepareStatement(req);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String prenom = rs.getString("prenom");
			String email = rs.getString("email");
			Date ddn = rs.getDate("ddn");
			String mdp = rs.getString("mdp");
			System.out.println(rs.getString("prenom"));
			Stagiaire stag = new Stagiaire(id, prenom, email, ddn, mdp);
			stg.add(stag);
		}
		
		return stg;
	}
	
	public void addStagiaire(Stagiaire stagiaire) throws SQLException {
		String req = "INSERT INTO stagiaire (prenom, email, mdp, ddn) VALUES (?, ?, ?, ?)";
		Connection con = MaConnexion.getInstance().getConnection();
		PreparedStatement st = con.prepareStatement(req);
		
		st.setString(1, req);
	}
}
