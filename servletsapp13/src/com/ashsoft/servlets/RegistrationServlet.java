package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1 style='color:red' align='center'>ASHISH SOFTWARE SOLUTIONS</h1>");
		out.println("<h2 style='color:brown' align='center'>Registration Details</h2>");
		out.println("<table border='1'bgcolor='lightblue' align='center'>");
		out.println("<tr><td>Name</td><td>"+request.getParameter("uname")+"</td></tr>");
		out.println("<tr><td>Password</td><td>"+request.getParameter("upwd")+"</td></tr>");
		out.println("<tr><td>Email</td><td>"+request.getParameter("uemail")+"</td></tr>");
		out.println("<tr><td>Mobile</td><td>"+request.getParameter("umobile")+"</td></tr>");
		out.println("<h3 align='center'><a href='./registrationform.html'>Registration Page</a></h3>");
		out.println("</table></body></html>");
	}

}
