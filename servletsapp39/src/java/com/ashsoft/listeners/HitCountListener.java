
package com.ashsoft.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class HitCountListener implements ServletRequestListener {
    int count=1;
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request Object Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
         System.out.println("Request Object Created");
         count=count+1;
         sre.getServletContext().setAttribute("count", count);
    }
}
