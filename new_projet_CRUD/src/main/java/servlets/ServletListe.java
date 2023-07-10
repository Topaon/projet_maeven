package servlets;

import java.io.IOException;
import java.util.ArrayList;

import crud.Stagiaire;
import crud.StagiaireService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/liste")
public class ServletListe extends HttpServlet {
	public StagiaireService ss;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ss = new StagiaireService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Stagiaire> listeStagiaires = ss.getAllStagiaires();
		request.setAttribute("listeStagiaires", listeStagiaires);
		request.getRequestDispatcher("/WEB-INF/pages/liste.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}