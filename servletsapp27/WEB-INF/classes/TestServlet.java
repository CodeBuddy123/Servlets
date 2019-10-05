import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test")
public class TestServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html<body>");
		out.println("<h1 style='color:blue' align='center'>WAR deployment on GlassFish Server</h1>");
		out.println("</body></html>");
	}
}