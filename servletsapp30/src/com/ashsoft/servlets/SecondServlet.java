package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uqual=request.getParameter("uqual");
		String udes=request.getParameter("udes");   //getting form data
		
		Cookie c3=new Cookie("uqual",uqual);       //creating Cookie object for every request parameter
		Cookie c4=new Cookie("udes",udes);
		
		response.addCookie(c3);
		response.addCookie(c4);                    //adding cookie to response object
		
		RequestDispatcher rd=request.getRequestDispatcher("form3.html");
		rd.forward(request, response);             //forwarding the request to form3.html
	}

}
