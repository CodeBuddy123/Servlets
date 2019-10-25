package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accType=request.getParameter("accType");
		String accBranch=request.getParameter("accBranch");  //getting form data
		
		HttpSession hs=request.getSession();
		hs.setAttribute("accType",accType);
		hs.setAttribute("accBranch",accBranch); //storing form data into HttpSession object
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");   //preparing dynamic form
		out.println("<h2 style='color:red' align='center'>Ashish Banking Services</h2>");
		out.println("<h2 style='color:blue' align='center'>Deposit Form[Cont..]</h2>");
		out.println("<form method='POST' action='"+response.encodeUrl("./deposit")+"'>");//adding SessionID in response header
		out.println("<center><table>");
		out.println("<tr><td>Deposit Amount</td><td><input type='text' name='depAmt'/></td></tr>");
		out.println("<tr><td>Depositor Name</td><td><input type='text' name='depName'/></td></tr>");
		out.println("<tr><td><input type='submit' value='NEXT'/></td></tr>");
		out.println("</table></center></form></body></html>");
	}

}
