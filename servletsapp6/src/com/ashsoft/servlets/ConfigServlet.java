package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletConfig config=getServletConfig();                     //getting ServletConfig object
		
		String logical_Name=config.getServletName();                 //getting Logical Name of servlet
		String driver_Class=config.getInitParameter("driver_Class"); //getting initparam with name driver_Class
		String driver_Url= config.getInitParameter("driver_Url");
		String db_Username=config.getInitParameter("db_Username");
		String db_Password=config.getInitParameter("db_Password");
		
		Enumeration<String>e=config.getInitParameterNames();        //Param names are stored in enumeration object
		String param_Names="";
		while(e.hasMoreElements())
		{
			param_Names=param_Names+e.nextElement()+"<br>";        //getting Param names from enumeration Object
		}
		
		out.println("<html><body>");                               //displaying data through an HTML page
		out.println("<table border='1'>");
		out.println("<tr><td>Logical Name</td><td>"+logical_Name+"</td></tr>");
		out.println("<tr><th colspan='2'>Initialization Parameters</th></tr>");
		out.println("<tr><td>Driver Class</td><td>"+driver_Class+"</td></tr>");
		out.println("<tr><td>Driver URL</td><td>"+driver_Url+"</td></tr>");
		out.println("<tr><td>Database UserName</td><td>"+db_Username+"</td></tr>");
		out.println("<tr><td>Database Password</td><td>"+db_Password+"</td></tr>");
		out.println("<tr><td>Parameter Names</td><td>"+param_Names+"</td></tr>");
		out.println("</table></html></body>");
	}

}
