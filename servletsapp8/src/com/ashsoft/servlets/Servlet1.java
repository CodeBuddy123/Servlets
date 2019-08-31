package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletConfig config=getServletConfig();
		ServletContext context=getServletContext();
		
		out.println("<html><body><h1>");
		out.println("a----->"+context.getInitParameter("a")+"<br>"); //A(context param are shared between servlets)
		out.println("b----->"+context.getInitParameter("b")+"<br>"); //B
		out.println("c----->"+config.getInitParameter("c")+"<br>");  //C
		out.println("d----->"+config.getInitParameter("d")+"<br>");  //D
		out.println("e----->"+config.getInitParameter("e")+"<br>");  //null(init param of servlet2 arent available to this servlet1)
		out.println("f----->"+config.getInitParameter("f")+"<br>");  //null(init param of servlet2 arent available to this servlet1)
		out.println("</h1></body></html>");
	}

}
