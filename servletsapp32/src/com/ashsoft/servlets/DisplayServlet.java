package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String sgender=request.getParameter("sgender");
		String saddr=request.getParameter("saddr");
		String semail=request.getParameter("semail");
		String smobile=request.getParameter("smobile");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 style='color:red' align='center'>Ashish Software Solutions</h2>");
		out.println("<h1 style='color:green' align='center'>Registration Details</h1>");
		out.println("<center>");
		out.println("<table border='1' bgcolor='lightyellow'>");
		out.println("<tr><td>Student ID</td><td>"+sid+"</td></tr>");
		out.println("<tr><td>Student Name</td><td>"+sname+"</td></tr>");
		out.println("<tr><td>Student Gender</td><td>"+sgender+"</td></tr>");
		out.println("<tr><td>Student Address</td><td>"+saddr+"</td></tr>");
		out.println("<tr><td>Student Email</td><td>"+semail+"</td></tr>");
		out.println("<tr><td>Student Mobile</td><td>"+smobile+"</td></tr>");
		out.println("</table></center></body</html>");
	}
}
