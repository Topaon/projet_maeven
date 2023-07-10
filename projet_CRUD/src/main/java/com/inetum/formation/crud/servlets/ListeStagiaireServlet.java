package com.inetum.formation.crud.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inetum.formation.crud.jdbc.IStagiaireService;
import com.inetum.formation.crud.jdbc.Stagiaire;
import com.inetum.formation.crud.jdbc.util.StagiaireService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
	
	@Override
	public void init() throws ServletException {
		service = new StagiaireService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Stagiaire> stagiaires = new ArrayList<>();
		
		try {
			stagiaires = service.allStagiaire();
			request.setAttribute("listeStagiaires", stagiaires);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erreur de type ClassNotFoundException ou SQLException");
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/liste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
