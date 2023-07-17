package fr.inetum.tp.test;

import java.io.IOException;

import fr.inetum.tp.entites.Stagiaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("attributTest", "attribut test");
		System.out.println("doGet du servlet test2 du projet JAVA/SQL");
		System.out.println(request.getParameter("parametreTest"));
		System.out.println(request.getAttribute("attributTest"));
		request.getRequestDispatcher("/WEB-INF/pages/test2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost du servlet test2 du projet JAVA/SQL");
		System.out.println(request.getParameter("parametreTest"));
		System.out.println(request.getAttribute("attributTest"));
//		response.sendRedirect("test3");
		request.getRequestDispatcher("/WEB-INF/pages/test3.jsp").forward(request, response);
	}
}