package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		UserService userService=new UserService();
		String status=userService.login(uname, upwd);
		
		out.println("<html><body>");
		out.println("<br><br>");
		if(status.equals("success"))
		{
			out.println("<h1 style='color:green' align='center'>Login Success</h1>");
			
		}
		else
		{
			out.println("<h1 style='color:red' align='center'>Login Failure</h1>");
		}
		out.println("</body></html>");
	}
}
