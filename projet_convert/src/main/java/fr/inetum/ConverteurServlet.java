package fr.inetum;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/converteur")
public class ConverteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet du servlet converteur");
		request.getRequestDispatcher("/WEB-INF/pages/converteur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost du servlet converteur");
		double deg = 0;
		double far = 0;
		try {
			deg = Double.parseDouble(request.getParameter("degre"));
			far = (deg*9/5)+32;
			request.setAttribute("far", far);
			request.setAttribute("probleme", "non");
		} catch (Exception e) {
			request.setAttribute("probleme", "oui");
		}
		doGet(request, response);
	}
}