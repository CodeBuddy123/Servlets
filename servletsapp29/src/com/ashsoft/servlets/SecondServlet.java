package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uqual=request.getParameter("uqual");
		String udes=request.getParameter("udes");        //getting present request data
		
		HttpSession hs=request.getSession();  //returns HttpSession Object  
		
		hs.setAttribute("uqual",uqual);
		hs.setAttribute("udes", udes);   //Storing the data into HttpSession Object
		
		RequestDispatcher rd=request.getRequestDispatcher("form3.html");
		rd.forward(request, response);   //forwarding request to form3.html
	}

}
