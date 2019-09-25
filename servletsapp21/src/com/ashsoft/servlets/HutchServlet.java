package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hutch")
public class HutchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		/*out.println("<html><body>");
		out.println("<br><br><br>");
		out.println("<center>");
		out.println("<h2>For Hutch Services,Please Click below Link</h2><br>");
		out.println("<h3><a href='http://localhost:5050/vodafoneapp/welcome.html'>CC@vodafone.com</a></h3>"); //the link belongs to vodafone app on tomcat server
		out.println("</center></body></html>");	*/
		
		/*response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("location","http://localhost:5050/vodafoneapp/welcome.html");*/
		
		response.sendRedirect("http://localhost:5050/vodafoneapp/welcome.html");
	}

}
