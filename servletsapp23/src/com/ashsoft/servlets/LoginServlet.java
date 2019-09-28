package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");         //getting login credentials
		
		RequestDispatcher requestDispatcher=null;
		
		if(uname.equalsIgnoreCase("ashish") && upwd.equals("ashish"))
		{
			requestDispatcher=request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);  //forwarding the request to success.html
		}
		else
		{
			requestDispatcher=request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);  //forwarding the request to failure.html
		}
	}
}
