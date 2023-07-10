package com.inetum;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/devine")
public class DevineServlet extends HttpServlet {
	int essai = 0;
	int solution = (int) Math.ceil(Math.random() * 10);
	ArrayList<Integer> historique = new ArrayList<Integer>();
	String probleme = "non";
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		essai += 1;
		request.setAttribute("essai", essai);
		request.setAttribute("solution", solution);
		request.getRequestDispatcher("/WEB-INF/pages/devine.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int reponse = Integer.parseInt((String)request.getParameter("reponse"));
			probleme = "non";
			historique.add(reponse);
			request.getSession().setAttribute("reponse" + Integer.toString(essai), reponse);
			if(reponse == solution || essai >= 3) {
				request.getSession().setAttribute("solution", solution);
				if(historique.contains(solution)) {
					request.getSession().setAttribute("gagne", "oui");
				} else {
					request.getSession().setAttribute("gagne", "non");
				}
				essai = 0;
				solution = (int) Math.ceil(Math.random() * 10);
				historique.clear();
				response.sendRedirect("resultat");
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			probleme = "oui";
			essai -= 1;
			doGet(request, response);
		}
	}
}
