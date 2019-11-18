
package com.ashsoft.servlets;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    String fileName="ash.jpg";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       PrintWriter out = response.getWriter();
       response.setContentType("APPLICATION/OCTET-STREAM");

       response.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");

       FileInputStream fis=new FileInputStream("H:/Images/ash.jpg");

       int i=fis.read();
       while (i != -1) {
          out.write(i);
          i=fis.read();
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
