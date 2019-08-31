package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletContext context=getServletContext();  //getting context object
		
		String logical_Name=context.getServletContextName(); //returns display-name of web.xml
		
		String driver_Class=context.getInitParameter("driver_Class");   //context-param values
		String driver_Url=context.getInitParameter("driver_Url");
		String db_Username=context.getInitParameter("db_Username");
		String db_Password=context.getInitParameter("db_Password");
		
		Enumeration<String>e=context.getInitParameterNames();   //getting Context Param Names
		String param_Names="";
		while(e.hasMoreElements())
		{
			param_Names=param_Names+e.nextElement()+"<br>";
		}
		
		context.setAttribute("trainer_Name","Ashish");        //we can set Attributes to Context Object
		context.setAttribute("course_Name","Java");
		
		String trainer_Name=(String) context.getAttribute("trainer_Name");   //getting attributes from Context Object
		String course_Name=(String) context.getAttribute("course_Name");
		
		Enumeration<String>e1=context.getAttributeNames();
		String attr_Names="";
		while(e1.hasMoreElements())                                     //getting attribute names
		{
			attr_Names=attr_Names+e1.nextElement()+"<br>";
		}
		out.println("<html><body>");                                  //displaying data in HTML as table
		out.println("<table border='1' align='center'>");
		out.println("<tr><td>Logical Name</td><td>"+logical_Name+"</td></tr>");
		out.println("<tr><th colspan='2'>Context Parameters</th></tr>");
		out.println("<tr><td>Driver Class</td><td>"+driver_Class+"</td></tr>");
		out.println("<tr><td>Driver Url</td><td>"+driver_Url+"</td></tr>");
		out.println("<tr><td>Database Username</td><td>"+db_Username+"</td></tr>");
		out.println("<tr><td>Database Password</td><td>"+db_Password+"</td></tr>");
		out.println("<tr><td>Parameter Names</td><td>"+param_Names+"</td></tr>");
		out.println("<tr><th colspan='2'>Context Attributes</th></tr>");
		out.println("<tr><td>Trainer Name</td><td>"+trainer_Name+"</td></tr>");
		out.println("<tr><td>Course Name</td><td>"+course_Name+"</td></tr>");
		out.println("<tr><td>Attribute Names</td><td>"+attr_Names+"</td></tr>");
		out.println("</table></html></body>");
	}
}
