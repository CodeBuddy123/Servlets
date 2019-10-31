
package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "RegistrationServlet", urlPatterns = {"/reg"})
public class RegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.setContentType("img/jpg"); //overridden in myresponse
            PrintWriter out=response.getWriter();
            
            String uname=request.getParameter("uname");
            String upwd=request.getParameter("upwd");      //getting form data
            String uemail=request.getParameter("uemail");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");                         //displaying data
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2 style='color:red' align='center'>Ashish Software Solutions</h1>");
            out.println("<h3 style='color:blue' align='center'>Registration Details</h1>");
            out.println("<center>");
            out.println("<table border='1' bgcolor='pink'>");
            out.println("<tr><td>User Name</td><td>"+uname+"</td></tr>");
            out.println("<tr><td>User Password</td><td>"+upwd+"</td></tr>");
            out.println("<tr><td>User Email</td><td>"+uemail+"</td></tr>");
            out.println("</table>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
