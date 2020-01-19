package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<h1 style='color:green' align='center'>Security Test</h1>");
		out.println("</body></html>");
	}

}
