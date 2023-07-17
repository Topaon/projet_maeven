package fr.inetum.tp.test;

import java.io.IOException;

import fr.inetum.tp.entites.Stagiaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet du servlet test du projet TP JAVA/SQL");
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setPrenom("Martin");
		request.setAttribute("stagiaire", stagiaire);
		request.getRequestDispatcher("/WEB-INF/pages/ajouter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost du servlet test du projet JAVA/SQL");
		
		System.out.println(request.getParameter("prenom"));
		
		response.sendRedirect("test");
	}
}