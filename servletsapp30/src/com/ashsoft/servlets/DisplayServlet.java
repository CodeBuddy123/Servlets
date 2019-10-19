package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail=request.getParameter("uemail");     //getting present request data from form3.html
		String umobile=request.getParameter("umobile");
		
		Cookie[] c=request.getCookies();
		
		String uname=c[0].getValue();
		String upwd=c[1].getValue();      //getting past request data from cookies
		String uqual=c[2].getValue();
		String udes=c[3].getValue();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter(); //display data
		out.println("<html><body>");
		out.println("<h1 style='color:red' align='center'>Registration Details</h1>");
		out.println("<center>");
		out.println("<table border='1' bgcolor='pink'>");
		out.println("<tr><td>User Name:"+uname+"</td></tr>");
		out.println("<tr><td>User Password:"+upwd+"</td></tr>");           //displaying all details
		out.println("<tr><td>User Designation:"+udes+"</td></tr>");
		out.println("<tr><td>User Qualification:"+uqual+"</td></tr>");
		out.println("<tr><td>User Mobile:"+uemail+"</td></tr>");
		out.println("<tr><td>User Email:"+umobile+"</td></tr>");
		out.println("</table></center></body></html>");
	}

}
