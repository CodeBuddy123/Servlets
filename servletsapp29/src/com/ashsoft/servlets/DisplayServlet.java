package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail=request.getParameter("uemail");
		String umobile=request.getParameter("umobile"); //getting present request data
		
		HttpSession hs=request.getSession();            //getting HttpSession Object
		
		String uname=(String) hs.getAttribute("uname");
		String upwd=(String) hs.getAttribute("upwd");   //getting previous requests data from HttpSession Object
		String uqual=(String) hs.getAttribute("uqual");
		String udes=(String) hs.getAttribute("udes");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");                 //displaying details
		out.println("<h2 style='color:green' align='center'>Ashish Software Solutions</h2>");
		out.println("<h1 style='color:maroon' align='center'>Registration Details</h1>");
		out.println("<center>");
		out.println("<table border='1' bgcolor='lightpink'>");
		out.println("<tr><td>User Name</td><td>"+uname+"</td></tr>");
		out.println("<tr><td>User Password</td><td>"+upwd+"</td></tr>");
		out.println("<tr><td>User Qualifcation</td><td>"+uqual+"</td></tr>");
		out.println("<tr><td>User Designation</td><td>"+udes+"</td></tr>");
		out.println("<tr><td>User Email</td><td>"+uemail+"</td></tr>");
		out.println("<tr><td>User Mobile</td><td>"+umobile+"</td></tr>");
		out.println("</table</center></body></html>");
	}

}
