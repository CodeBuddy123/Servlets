
package com.ashsoft.custom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class MyRequest extends HttpServletRequestWrapper {
      
    HttpServletRequest request;
      
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request=request;  //constructor
    }

    @Override
    public String getParameter(String name) {
        String val=request.getParameter(name);
        if(name.equals("uemail"))
        {
            if(!val.endsWith("@dss.com"))
            {                               //customizing request object
                val=val+"@dss.com";
            }
        }
        return val;
    }
}
