package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accNo=request.getParameter("accNo");
		String accName=request.getParameter("accName");  //getting form data
		
		HttpSession hs=request.getSession();            //getting HttpSession object
		hs.setAttribute("accNo",accNo);
		hs.setAttribute("accName",accName);            //Storing data into HttpSession object
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");                   //preparing dynamic form
		out.println("<h2 style='color:red' align='center'>Ashish Banking Services</h2>");
		out.println("<h2 style='color:blue' align='center'>Deposit Form[Cont..]</h2>");
		out.println("<form method='POST' action='"+response.encodeUrl("./second")+"'>");
		out.println("<center><table>");
		out.println("<tr><td>Account Type</td><td><input type='text' name='accType'/></td></tr>");
		out.println("<tr><td>Account Branch</td><td><input type='text' name='accBranch'/></td></tr>");
		out.println("<tr><td><input type='submit' value='NEXT'/></td></tr>");
		out.println("</table></center></form></body></html>");
		
	}

}
