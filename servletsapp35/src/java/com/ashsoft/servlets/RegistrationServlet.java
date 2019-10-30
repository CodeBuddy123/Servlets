
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            String uname=request.getParameter("uname");
            String upwd=request.getParameter("upwd");
            int uage=Integer.parseInt(request.getParameter("uage"));
            String uemail=request.getParameter("uemail");
            String umobile=request.getParameter("umobile");
   
        
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2 style='color:green' align='center'>Ashish Software Solutions</h2>");
            out.println("<h1 style='color:maroon'align='center'>Registration Details</h1>");
            out.println("<center>");
            out.println("<table border='1' bgcolor='lightblue'>");
            out.println("<tr><td>User Name</td><td>"+uname+"</td></tr>");
            out.println("<tr><td>User Password</td><td>"+upwd+"</td></tr>");
            out.println("<tr><td>User Age</td><td>"+uage+"</td></tr>");
            out.println("<tr><td>User Email</td><td>"+uemail+"</td></tr>");
            out.println("<tr><td>User Mobile</td><td>"+umobile+"</td></tr>");
            out.println("</table></center>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
      
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
