package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname"); //getting form data
		String upwd=request.getParameter("upwd");
		
		out.println("<html><body>");
		out.println("<h1 style='color:blue' align='center'>Ashish Software Solutions</h1>");
		
		if(uname.equals("ashish") && upwd.equals("ashish"))
		{
			out.println("<h2 style='color:green'align='center'>LOGIN SUCCESS</h2>");
		}
		else
		{
			out.println("<h2 style='color:red'align='center'>LOGIN FAILURE</h2>");
		}
		out.println("<h3 align='center'><a href='./loginform.html'>Login Page</a></h3>");
		out.println("</body></html>");
	}

}
