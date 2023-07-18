package fr.inetum.tp.servlets;
import java.io.IOException;
import java.util.ArrayList;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ListeServlet extends HttpServlet {
	public StagiaireService ss;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ss = new StagiaireService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet du servlet liste");
		String id = request.getParameter("idsup");
		if (id != null) {
			Stagiaire stagiaire = ss.getStagiaire(Integer.parseInt(id));
			ss.removeStagiaire(stagiaire);
		}
		ArrayList<Stagiaire> listeStagiaires = ss.allStagiaire();
		request.setAttribute("listeStagiaires", listeStagiaires);
		request.getRequestDispatcher("/WEB-INF/pages/liste.jsp").forward(request, response);
	}
}