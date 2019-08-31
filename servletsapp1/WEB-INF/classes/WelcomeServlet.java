//Preparing a Servlet by implementing Servlet Interface
import javax.servlet.*;
import java.io.*;

public class WelcomeServlet implements Servlet 
{

    //Below Method contains Application Logic
	public void service(ServletRequest request,ServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html><body>");
		out.println("<h1>Welcome to Servlets Training</h1>");
		out.println("</body></html>");
	}
	public void init(ServletConfig config) throws ServletException
	{

	}
	public void destroy()
	{

	}
	public String getServletInfo()
	{
		return "";
	}

	public ServletConfig getServletConfig()
	{
		return null;
	}
}