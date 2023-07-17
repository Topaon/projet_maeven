package fr.inetum.tp.servlets;

import java.io.IOException;
import java.sql.Date;

import fr.inetum.tp.entites.Adresse;
import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.AdresseService;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet du servlet ajouter");
		if(request.getParameter("id") != null) {
			AdresseService as = new AdresseService();
			Adresse adresse = as.readAdresse(Integer.parseInt(request.getParameter("adresseId")));
			Stagiaire stagiaireAdd = new Stagiaire(
					Integer.parseInt(request.getParameter("id")), 
					request.getParameter("prenom"),
					request.getParameter("email"),
					request.getParameter("mdp"),
					adresse,
					Date.valueOf(request.getParameter("ddn")),
					request.getParameter("role"));
			stagiaireAdd.setId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("stagiaireAdd", stagiaireAdd);
		}
		request.getRequestDispatcher("/WEB-INF/pages/ajouter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost du servlet ajouter");
		AdresseService as = new AdresseService();
		
		String prenom = request.getParameter("prenomNew");
		String email = request.getParameter("emailNew");
		String mdp = request.getParameter("mdpNew");
		Date ddn = Date.valueOf(request.getParameter("ddnNew"));
		String role = request.getParameter("roleNew");
		
		String nomVoie = request.getParameter("nomVoieNew");
		String codePostal = request.getParameter("codePostalNew");
		String ville = request.getParameter("villeNew");
		
		StagiaireService ss = new StagiaireService();
		
		if (request.getParameter("action") != null) {
			Integer id = Integer.parseInt(request.getParameter("idNew"));
			Adresse adresse = as.readAdresse(Integer.parseInt(request.getParameter("adresseId")));
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresse, ddn, role);
			ss.updateStagiaire(stagiaire);
		} else {
			Integer id = 0;
			Adresse adresse = new Adresse(id, nomVoie, codePostal, ville);
			Stagiaire stagiaire = new Stagiaire(id, prenom, email, mdp, adresse, ddn, role);
			ss.addStagiaire(stagiaire, adresse);
		}
		response.sendRedirect("liste");
	}
}
