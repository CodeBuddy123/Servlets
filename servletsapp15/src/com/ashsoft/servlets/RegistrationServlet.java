package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.service.UserService;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String uemail=request.getParameter("uemail");
		String umobile=request.getParameter("umobile");
		
		UserService userService=new UserService();
		String status=userService.register(uname, upwd, uemail, umobile);
		
		out.println("<html><body>");
		out.println("<br><br>");
		
		if(status.equals("success"))
		{
			out.println("<h1 style='color:green' align='center'>Registation Success</h1>");
		}
		else if(status.equals("failure"))
		{
			out.println("<h1 style='color:red' align='center'>Registation Failure</h1>");
		}
		else
		{
			out.println("<h1 style='color:brown' align='center'>User Already Existed</h1>");
		}
		out.println("</body></html>");
	}

}
