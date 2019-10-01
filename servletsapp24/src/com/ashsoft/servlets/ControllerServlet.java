package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.dto.Student;
import com.ashsoft.factory.ConnectionFactory;
import com.ashsoft.factory.StudentDaoFactory;
import com.ashsoft.factory.StudentServiceFactory;
import com.ashsoft.service.StudentService;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {     //This Method is executed during Server Startup during ControllerServlet lifecycle
		ConnectionFactory.getConnection();
		StudentServiceFactory.getStudentService();   //Creating Object at this phase increases Application Performance
		StudentDaoFactory.getStudentDao();
		System.out.println("*******Connection Object Created*******");
		System.out.println("*******StudentService Object Created*******"); 
		System.out.println("*******StudentDao Object Created*******");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String request_URI=request.getRequestURI();
		
		if(request_URI.endsWith("home.do"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("home.html");
			requestDispatcher.forward(request, response);
		}
		
		if(request_URI.endsWith("addform.do"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("addform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("deleteform.do"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("deleteform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("searchform.do"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("searchform.html");
			requestDispatcher.forward(request, response);
		}
		if(request_URI.endsWith("updateform.do"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateform.html");
			requestDispatcher.forward(request, response);
		}
		//***************ADD MODULE**********
		if(request_URI.endsWith("add.do"))
		{
			String sid=request.getParameter("sid");
			String sname=request.getParameter("sname");
			String saddr=request.getParameter("saddr");
			
			StudentService stdService=StudentServiceFactory.getStudentService();
			String status=stdService.addStudent(sid, sname, saddr);
			RequestDispatcher requestDispatcher=null;
			if(status.equals("success"))
			{
				requestDispatcher=request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("failure"))
			{
				requestDispatcher=request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if(status.equals("existed"))
			{
				requestDispatcher=request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
				   
		}
		//***************DELETE MODULE**********
	   if(request_URI.endsWith("delete.do"))
	   {
		   String sid=request.getParameter("sid");
		   
		   StudentService stdService=StudentServiceFactory.getStudentService();
		   String status=stdService.deleteStudent(sid);
		   
		   RequestDispatcher requestDispatcher=null;
		   if(status.equals("success"))
		   {
			   requestDispatcher=request.getRequestDispatcher("success.html");
			   requestDispatcher.forward(request, response);
		   }
		   if(status.equals("failure"))
		   {
			   requestDispatcher=request.getRequestDispatcher("failure.html");
			   requestDispatcher.forward(request, response);
		   }
		   if(status.equals("not existed"))
		   {
			   requestDispatcher=request.getRequestDispatcher("notexisted.html");
			   requestDispatcher.forward(request, response);
		   }
	   }
	
	//***************SEARCH MODULE**********
	   if(request_URI.endsWith("search.do"))
	   {
		   String sid=request.getParameter("sid");
		   
		   StudentService stdService=StudentServiceFactory.getStudentService();
		   Student std=stdService.searchStudent(sid);
		   
		   RequestDispatcher requestDispatcher=null;
		   if(std==null)
		   {
			   requestDispatcher=request.getRequestDispatcher("notexisted.html");
			   requestDispatcher.forward(request, response);
		   }
		   else
		   {
			   response.setContentType("text/html");
			   PrintWriter out=response.getWriter();
			   out.println("<html>");
			   out.println("<body bgcolor='lightblue'");
			   out.println("<br><br><br>");
			   out.println("<h2 style='color:blue' align='center'>Student Details</h2>");
			   out.println("<center>");
			   out.println("<table border='1'>");
			   out.println("<tr><th>Student ID</th><td>"+std.getSid()+"</td></tr>");
			   out.println("<tr><th>Student Name</th><td>"+std.getSname()+"</td></tr>");
			   out.println("<tr><th>Student Address</th><td>"+std.getSaddr()+"</td></tr>");
			   out.println("</table></center></body></html>");
		   }
	   }
	   //***************UPDATE MODULE**********
	   if(request_URI.endsWith("editform.do"))
	   {
		   String sid=request.getParameter("sid");
		   
		  StudentService stdService=StudentServiceFactory.getStudentService();
		  Student std=stdService.getStudent(sid);
		  
		  RequestDispatcher requestDispatcher=null;
		  if(std==null)
		  {
			  requestDispatcher=request.getRequestDispatcher("notexisted.html");
			  requestDispatcher.forward(request, response);
		  }
		  else
		  {
			  response.setContentType("text/html");
			  PrintWriter out=response.getWriter();
			  out.println("<html><body bgcolor='lightblue'>");
			  out.println("<br><br><br>");
			  out.println("<h2 style='color:blue' align='center'>Student EditForm</h2>");
			  out.println("<form action='update.do' method='post'>");
			  out.println("<center>");
			  out.println("<table>");
			  out.println("<tr><td>Student ID</td><td>"+std.getSid()+"</td></tr>");
			  out.println("<tr><td><input type='hidden' name='sid' value='"+std.getSid()+"'/></td></tr>");
			  out.println("<tr><td>Student Name</td><td><input type='text' name='sname' value='"+std.getSname()+"'/>");
			  out.println("<tr><td>Student Address</td><td><input type='text' name='saddr' value='"+std.getSaddr()+"'/>");
			  out.println("<tr><td><input type='submit' value='UPDATE'></td></tr>");
			  out.println("</table></center></form</body></html>");
			  
		  }
	   }
	   if(request_URI.endsWith("update.do"))
	   {
		String sid=request.getParameter("sid");
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		
		StudentService stdService=StudentServiceFactory.getStudentService();
		String status=stdService.updateStudent(sid, sname, saddr);
		
		RequestDispatcher requestDispatcher=null;
		if(status.equals("success"))
		{
			requestDispatcher=request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);
		}
		if(status.equals("failure"))
		{
			requestDispatcher=request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);
		}
	   }
	}
    @Override
    public void destroy() { //method is executed during ControllerServlet Deinstantiation
    	ConnectionFactory.cleanUp(); //Connection Object is destroyed
    	System.out.println("****Connection Object Destroyed****");
    }
}
