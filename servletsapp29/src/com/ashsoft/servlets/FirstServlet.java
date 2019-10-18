package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");        //getting present request data
		
		HttpSession hs=request.getSession();  //creates HttpSession Object and returns it
		
		hs.setAttribute("uname",uname);
		hs.setAttribute("upwd", upwd);   //Storing the data into HttpSession Object
		
		RequestDispatcher rd=request.getRequestDispatcher("form2.html");
		rd.forward(request, response);   //forwarding request to form2.html
		
	}

}
