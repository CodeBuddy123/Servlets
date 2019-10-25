package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String sgender=request.getParameter("sgender");
		String saddr=request.getParameter("saddr");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<h2 style='color:red' align='center'>Ashish Software Solutions</h2>");
		out.println("<h3 style='color:red' align='center'>Student Registration Page[Cont..]</h3>");
		out.println("<form action='./display' method='POST'>");
		out.println("<center>");
		out.println("<table>");
		out.println("<tr><td>Student Email</td><td><input type='text' name='semail'></td></tr>");
		out.println("<tr><td>Student Mobile</td><td><input type='text' name='smobile'></td></tr>");
		out.println("<tr><td><input type='hidden' name='sid'  value='"+sid+"'</td></tr>");
		out.println("<tr><td><input type='hidden' name='sname' value='"+sname+"'</td></tr>");
		out.println("<tr><td><input type='hidden' name='sgender' value='"+sgender+"'</td></tr>");
		out.println("<tr><td><input type='hidden' name='saddr'value='"+saddr+"'</td></tr>");
		out.println("<tr><td><input type='submit' value='Display'></td></tr>");
		out.println("</table</center></form></body></html>");
	}

}
