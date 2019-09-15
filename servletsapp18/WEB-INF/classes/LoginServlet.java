import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");

		out.println("<html><body>");
		out.println("<h1 style='color:blue'>ASHISH SOFTWARE SOLUTIONS</h1>");
		out.println("<h2 style='color:brown'>Login Status</h2>");

		if(uname.equals("ashish") && upwd.equals("ashish"))
		{
			out.println("<h1 style='color:green'>Login Success</h1>");
		}
		else
		{
			out.println("<h1 style='color:red'>Login failure</h1>");
		}
		out.println("</body></html>");

	}
}