//Preparing Servlet Extending HttpServlet
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WelcomeServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html><body>");
		out.println("<h1 style='color:blue'>Preparing Servlet Extending HttpServlet</h1>");
		out.print("</body></html>");
	}
}