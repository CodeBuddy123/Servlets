
package com.ashsoft.filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName = "ValidationFilter", urlPatterns = {"/reg"})
public class ValidationFilter implements Filter {
        
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain)        throws IOException, ServletException {
        
        String error_Uname="";
        String error_Upwd="";
        String error_Uage="";
        String error_Uemail="";
        String error_Umobile="";
        boolean flag=true;
        
        String uname=request.getParameter("uname");
        String upwd=request.getParameter("upwd"); //getting form data
        String uage=request.getParameter("uage");
        String uemail=request.getParameter("uemail");
        String umobile=request.getParameter("umobile");
        
        if(uname==null ||uname.equals(""))  //checking if data is empty or not
        {
            flag=false;
            error_Uname="User Name is Required";  //Preparing error message if it field is empty
        }
        
         if(upwd==null ||upwd.equals(""))
        {
            flag=false;
            error_Upwd="User Password is Required";
        }
         else
         {
             int length=upwd.length();
             if(length<=6)
             {
                 flag=false;
                 error_Upwd="Password must be atleast 6 characters";
             }
             if(length>10)
             {
                 flag=false;
                 error_Upwd="Password must not exceed 10 characters";
             }
         }
        if(uage==null ||uage.equals(""))
        {
            flag=false;
            error_Uage="User Age is Required";
        }
        else
        {
            int age=Integer.parseInt(uage);
            if(age<18)
            {
                flag=false;
                error_Uage="You must be atleast 18 years old";
            }
            else if(age>30)
            {
                flag=false;
                error_Uage="You must be less than 30 years old";
            }
        }
        if(uemail==null ||uemail.equals(""))
        {
            flag=false;
            error_Uemail="User Email is Required";
        }
        else
        {
            if(!uemail.contains("@"))
            {
                flag=false;
                error_Uemail="Please provide valid Email Format";
            }
        }
        if(umobile==null ||umobile.equals(""))
        {
            flag=false;
            error_Umobile="User Mobile is Required";
        }
        else
        {
           if(!umobile.startsWith("+91"))
           {
               flag=false;
               error_Umobile="Please Prefix Country Code";
           }
        }
        
       if(flag==true)   //if data is valid,forward request to servlet
       {
           chain.doFilter(request, response);
       }
       else           //if data is invalid,prepare dynamic form with error messages
       {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h2 style='color:red' align='center'>Ashish Software Solutions</h2>");
        out.println("<h3 style='color:blue' align='center'>Registration Page</h3>");
        out.println("<form action='./reg' method='POST'>");
        out.println("<center>");
        out.println("<table>");
        
        out.println("<tr>");
        out.println("<td>User Name</td>");
        out.println("<td><input type='text' name='uname' value='"+uname+"'></td>");
        out.println("<td><h3 style='color:red'>"+error_Uname+"</h3></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>User Password</td>");
        out.println("<td><input type='password' name='upwd' value='"+upwd+"'></td>");
         out.println("<td><h3 style='color:red'>"+error_Upwd+"</h3></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>User Age</td>");
        out.println("<td><input type='text' name='uage' value='"+uage+"'></td>");
        out.println("<td><h3 style='color:red'>"+error_Uage+"</h3></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>User Email</td>");
        out.println("<td><input type='text' name='uemail' value='"+uemail+"'></td>");
        out.println("<td><h3 style='color:red'>"+error_Uemail+"</h3></td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>User Mobile</td>");
        out.println("<td><input type='text' name='umobile' value='"+umobile+"'></td>");
        out.println("<td><h3 style='color:red'>"+error_Umobile+"</h3></td>");
        out.println("</tr>");
        out.println("<tr><td><input type='submit' value='Register'/></td></tr>");
        out.println("</table></center></form></body></html>");
       }
    }

    
    public void destroy() {        
    }

    
    public void init(FilterConfig filterConfig) {        
       
        }
 
    
}
