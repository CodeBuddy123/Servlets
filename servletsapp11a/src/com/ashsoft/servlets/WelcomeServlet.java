package com.ashsoft.servlets;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Welcome Servlet Initialization...");
	}
	public void destroy() {
		System.out.println("Welcome Servlet  Deinstantiation...");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome Servlet Request Processing...");
	}
	static
	{
		System.out.println("Welcome Servlet Loading...");
	}
	public WelcomeServlet() {
		System.out.println("Welcome Servlet Instantiation...");
	}

}
