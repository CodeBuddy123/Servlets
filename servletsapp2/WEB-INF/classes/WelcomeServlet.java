import java.io.*;
import javax.servlet.*;

public class WelcomeServlet extends GenericServlet
{
	public void service(ServletRequest request,ServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html><body>");
		out.println("<h1 style='color:green'>Preparing Servlet by Extending GenericServlet</h1>");
		out.println("</body></html>");
	}
}