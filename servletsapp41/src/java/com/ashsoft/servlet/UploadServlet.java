
package com.ashsoft.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DiskFileItemFactory factory= new DiskFileItemFactory();
            ServletFileUpload sfu= new ServletFileUpload(factory);
            
            List<FileItem> multiparts=sfu.parseRequest(request);
            
            for(FileItem fileItem:multiparts)
            {
                File file= new File(fileItem.getName());
                String fileName=file.getName();
                File target_File= new File("G:/uploads/"+fileName);
                fileItem.write(target_File);
            }
            
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("status.html");
            requestDispatcher.forward(request, response);
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
