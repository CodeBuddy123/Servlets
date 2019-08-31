import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/test")

public class TestServlet extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<html<body>");
		out.println("<h1 style='color:brown'>WAR deployment on WebLogic Server</h1>");
		out.println("</body></html>");
	}
}