package com.inetum;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import jakarta.ws.rs.core.Response;

@WebServlet("/resultat")
public class Resultat extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int solution = (int) request.getSession().getAttribute("solution");
		String gagne = (String) request.getSession().getAttribute("gagne");
		
		if(request.getSession().getAttribute("reponse1") == null) {
			
		} else {
			int reponse1 = (int) request.getSession().getAttribute("reponse1");
			request.setAttribute("reponse1", reponse1);
		}
		
		if(request.getSession().getAttribute("reponse2") == null) {
			
		} else {
			int reponse2 = (int) request.getSession().getAttribute("reponse2");
			request.setAttribute("reponse2", reponse2);
		}
		
		if(request.getSession().getAttribute("reponse3") == null) {
	
		} else {
			int reponse3 = (int) request.getSession().getAttribute("reponse3");
			request.setAttribute("reponse3", reponse3);
		}
		
		request.setAttribute("solution", solution);
		request.setAttribute("gagne", gagne);
		request.getRequestDispatcher("WEB-INF/pages/resultat.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("gagne", null);
		request.getSession().setAttribute("solution", null);
		request.getSession().setAttribute("reponse1", null);
		request.getSession().setAttribute("reponse2", null);
		request.getSession().setAttribute("reponse3", null);
		response.sendRedirect("devine");
	}
}
