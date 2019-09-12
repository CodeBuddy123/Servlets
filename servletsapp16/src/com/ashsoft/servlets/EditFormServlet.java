package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.dto.Student;
import com.ashsoft.factory.StudentServiceFactory;
import com.ashsoft.service.StudentService;



@WebServlet("/edit")
public class EditFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("sid");
		
		StudentService stdService=StudentServiceFactory.getStudentService();
		Student std=stdService.getStudent(sid);
		
		if(std==null)
		{
			out.println("<html><body>");
			out.println("<br><br><br>");
			out.println("<h2 style='color:blue' align='center'>ASHISH SOFTWARE SOLUTIONS</h2>");
			out.println("<h3 style='color:green' align='center'>Student Updation Status</h3>");
			out.println("<h2 style='color:red' align='center'>Student not Existed</h2>");
			out.println("<h3 align='center'><a href='./updateform.html'>|Update Form|</a></h3>");
			out.println("</body></html>");
			
		}
		else
		{
			out.println("<html><body>");
			out.println("<br><br><br>");
			out.println("<h2 style='color:blue' align='center'>ASHISH SOFTWARE SOLUTIONS</h2>");
			out.println("<h3 style='color:green' align='center'>Student Edit Form</h3>");
			out.println("<form action='./update' method='POST'>");
			out.println("<center>");
			out.println("<table>");
			out.println("<tr><td>Student ID</td><td>"+std.getSid()+"<input type='hidden' name='sid' value='"+std.getSid()+"'/></td></tr>");//sid is unchangable.
			out.println("<tr><td>Student Name</td><td><input type='text' name='sname'value='"+std.getSname()+"'/></td></tr>");
			out.println("<tr><td>Student Address</td><td><input type='text' name='saddr'value='"+std.getSaddr()+"'/></td></tr>");
			out.println("<tr><td><input type='submit' value='Update'></td></tr>");
			out.println("</table></center></form></body></html>");
		}
	}

}
