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
		
		String sname=request.getParameter("sname");
		String sgender=request.getParameter("sgender");
		
		String[] qual=request.getParameterValues("squal");
		String squal="";
		for(String s:qual)
		{
			squal=squal+s+"<br>";
		}
		
		String[] course=request.getParameterValues("scourses");
		String scourses="";
		for(String s1:course)
		{
			scourses=scourses+s1+"<br>";
		}
		
		String saddr=request.getParameter("saddr");
		String sbranch=request.getParameter("sbranch");
		
		out.println("<html><body>");
		out.println("<h1 style='color:green'align='center'>ASHISH SOFTWARE SOLUTIONS</h1>");
		out.println("<h2 style='color:maroon'align='center'>Registration Details</h2>");
		out.println("<table bgcolor='lightblue' align='center' border='1'>");
		out.println("<tr><td>Name</td><td>"+sname+"</td></tr>");
		out.println("<tr><td>Gender</td><td>"+sgender+"</td></tr>");
		out.println("<tr><td>Courses</td><td>"+scourses+"</td></tr>");
		out.println("<tr><td>Branch</td><td>"+sbranch+"</td></tr>");
		out.println("<tr><td>Address</td><td>"+saddr+"</td></tr>");
		out.println("</table>");
		out.println("<h3 align='center'><a href='./registrationform.html'>RegistrationForm</a></h3>");
		out.println("</body></html>");
		
		
	}

}
