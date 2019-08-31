package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Enumeration<String>e=request.getHeaderNames();  //getting headernames
		
		out.println("<html><body>");
		out.println("<h1 style='color:blue' align='center'>Request Header Details</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>Header Names</th><th>Header Values</th></tr>");
		while(e.hasMoreElements())
		{
			String header_Names=e.nextElement();
			String header_Values=request.getHeader(header_Names);
			out.println("<tr><td>"+header_Names+"</td><td>"+header_Values+"</td></tr>");
		}
		out.println("</table></body></html>");
	}
}
