package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello Servlet Request Processing...");
	}
	static
	{
		System.out.println("Hello Servlet Loading...");
	}
	public HelloServlet() {
		System.out.println("Hello Servlet Instantiation...");
	}
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello Servlet Initialization...");
	}
	public void destroy() {
		System.out.println("Hello Servlet  Deinstantiation...");
	}

}
