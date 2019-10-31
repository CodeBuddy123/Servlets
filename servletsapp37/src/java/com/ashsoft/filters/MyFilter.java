package com.ashsoft.filters;

import com.ashsoft.custom.MyRequest;
import com.ashsoft.custom.MyResponse;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(filterName = "MyFilter", urlPatterns = {"/reg"})
public class MyFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest hreq=(HttpServletRequest) request;
        HttpServletResponse hres=(HttpServletResponse) response;
        MyRequest mreq=new MyRequest(hreq);
        MyResponse mres=new MyResponse(hres);
        chain.doFilter(mreq, mres);      //passing our own request and response objects to servlet     
    }    
 
    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
       
        }
}