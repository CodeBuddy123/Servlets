
package com.ashsoft.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AuthenticationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest hreq=(HttpServletRequest)request;   //Wrapping request and response objects
        HttpServletResponse hres=(HttpServletResponse)response;
        
        RequestDispatcher requestDispatcher=null;
        if(hreq.getMethod().equalsIgnoreCase("GET"))      //forwarding the request to loginform.html if request type is "GET"
        {
            requestDispatcher=request.getRequestDispatcher("loginform.html");
            requestDispatcher.forward(hreq, hres);
        }
        else
        {
            String uname=request.getParameter("uname");
            String upwd=request.getParameter("upwd");
            
            if(uname.equalsIgnoreCase("ashish") && upwd.equals("ashish"))
            {
                chain.doFilter(hreq, hres); //forwarding the request to servlet if credentials are correct
            }
            else
            {
                requestDispatcher=request.getRequestDispatcher("loginform.html");
                requestDispatcher.forward(hreq, hres);  //forwarding the request to form,on failure
            }
        }
       
    }


    public void destroy() {        
    }

    public void init(FilterConfig filterConfig) {        
     
    }
    
}
