package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sname=request.getParameter("sname");
		String scourse=request.getParameter("scourse"); //getting form data
		String squal=request.getParameter("squal");
		
		if(!(squal.equals("BTECH") || squal.equals("BCA") || squal.equals("MTECH") || squal.equals("MCA"))) //if squal is not from these 
		{
			response.sendError(505,sname+",You are ineligible for this course "+scourse+" as your "+squal+" doesnot meet our requirement");//send this error msg to user
		}
		else //display registration details
		{
			out.println("<html><body>");
			out.println("<h2 style='color:red' align='center'>ASHISH SOFTWARE SOLUTIONS</h2>");
			out.println("<h3 style='color:green' align='center'>Registration Details</h2>");
			out.println("<center>");
			out.println("<table border='1' bgcolor='lightblue'>");
			out.println("<tr><td>Name</td><td>"+sname+"</td></tr>");
			out.println("<tr><td>Course</td><td>"+scourse+"</td></tr>");
			out.println("<tr><td>Qualification</td><td>"+squal+"</td></tr>");
			out.println("</table>");
			out.println("<h3><a href='./registrationform.html'>Registration</a></h3>");
			out.println("</center></body></html>");
			
		}
	}

}
