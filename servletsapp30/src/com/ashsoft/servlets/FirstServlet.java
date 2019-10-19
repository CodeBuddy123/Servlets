package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");   //getting form data
		
		Cookie c1=new Cookie("uname",uname);       //creating Cookie object for every request parameter
		Cookie c2=new Cookie("upwd",upwd);
		
		response.addCookie(c1);
		response.addCookie(c2);                    //adding cookie to response object
		
		RequestDispatcher rd=request.getRequestDispatcher("form2.html");
		rd.forward(request, response);             //forwarding the request to form2.html
	}

}
