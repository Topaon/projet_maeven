package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.Date;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Boolean authorized = false;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet du servlet login");
		if(request.getSession().getAttribute("failed") == "oui") {
			request.setAttribute("failed", "oui");
		}
		// Ces quatres lignes servent à faciliter le développement de la page Liste.jsp et doivent être retirées à la fin
//		Adresse adresse = new Adresse(1, "avenue", "75016", "Paris");
//		Stagiaire stagiaire = new Stagiaire(0, "Simon", "s@sfr.fr", "123", adresse, Date.valueOf("1997-07-25"), "admin");
//		request.getSession().setAttribute("user", stagiaire);
//		request.getSession().setAttribute("testPersistence", stagiaire);
//		response.sendRedirect("liste");
		
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost du servlet login");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		
		Stagiaire stagiaire = new Stagiaire();
		StagiaireService ss = new StagiaireService();
		
		stagiaire = ss.getStagiaire(email, mdp);
		
		if (stagiaire.getEmail() != null && stagiaire.getMdp()!= null && stagiaire.getEmail().equals(email) && stagiaire.getMdp().equals(mdp)) {
			request.getSession().setAttribute("user", stagiaire);
			request.getSession().setAttribute("failed", "non");
			response.sendRedirect("liste");
		} else {
			request.getSession().setAttribute("failed", "oui");
			response.sendRedirect("login");
		}
	}
}