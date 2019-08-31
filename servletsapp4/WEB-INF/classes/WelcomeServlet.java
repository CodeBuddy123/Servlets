
// jar-cvf servletsapp4.war * creates war file. execute at application folder
package com.ashsoft.servlets;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html><body>");
		out.println("<h1 style='color:red'>War File Deployment in Tomcat Server!</h1>");
		out.println("</body></html>");
	}
}