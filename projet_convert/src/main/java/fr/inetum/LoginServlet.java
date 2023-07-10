package fr.inetum;

import java.io.IOException;

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
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		if (email.equals("stagiaire@inetum.com") && mdp.equals("1234")) {
			User user = new User(email, mdp);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("converteur");
		} else {
			response.sendRedirect("login");
		}
	}
}