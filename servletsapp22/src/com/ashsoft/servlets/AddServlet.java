package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.dto.Student;
import com.ashsoft.service.StudentService;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("sid");  //getting form data
		String sname=request.getParameter("sname");
		String saddr=request.getParameter("saddr");
		
		StudentService stdService=new StudentService();
		stdService.addStudent(sid, sname, saddr);          //sending data to service layer
		
		List<Student> stdList=stdService.getStudents();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h2 style='color:green' align='center'>Ashish Software Solutions<h2>");
		out.println("<h3 style='color:brown' align='center'>Students List<h2>");
		out.println("<center>");
		out.println("<table border='1' bgcolor='lightblue'>");
		out.println("<tr><th>Student ID</th><th>Student Name</th><th>Address</th><tr>");
		for(Student student:stdList)
		{
			out.println("<tr>");
			out.println("<td>"+student.getSid()+"</td>");
			out.println("<td>"+student.getSname()+"</td>");  //getting Students List as Table
			out.println("<td>"+student.getSaddr()+"</td>");
			out.println("</tr>");	
		}
		
		out.println("</table></center></body></html>");
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("addform.html");  //Creating RequestDispatcher Object
		requestDispatcher.include(request, response); //Including the Content of addform.html in same response		
	}

}
