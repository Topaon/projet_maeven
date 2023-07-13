package servlets;

import java.io.IOException;

import crud.Stagiaire;
import crud.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ajouter")
public class ServletAjouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id") != null) {
			Stagiaire sta = new Stagiaire(
					Integer.parseInt(request.getParameter("id")), 
					request.getParameter("prenom"),
					request.getParameter("mdp"),
					request.getParameter("email"),
					request.getParameter("ddn"));
			request.setAttribute("stagiaire", sta);
		}
		request.getRequestDispatcher("/WEB-INF/pages/ajouter.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String ddn = request.getParameter("ddn");
		
		Stagiaire s = new Stagiaire(id, prenom, mdp, email, ddn);
		StagiaireService ss = new StagiaireService();
		
		System.out.println(s.toString());
		
//		if (request.getParameter("action") != null) {
//			s.setId(Integer.parseInt(request.getParameter("id")));
//			ss.modifierStagiaire(s);
//		} else {
//			ss.ajouterStagiaire(s);
//		}
		
		response.sendRedirect("liste");
	}
}
