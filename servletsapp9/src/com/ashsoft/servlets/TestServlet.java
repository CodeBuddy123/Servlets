package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		description = "Test Servlet",
		loadOnStartup=1,//corresponds to <load-on-startup>tag in xml file
		name="TestServ",//corresponds to <servlet-name>(logicalname)in xml file
		
		urlPatterns = { 
				"/test2", //corresponds to <url-pattern> in web.xml file
				"/test1", 
				"/test3"
		}, 
		initParams = { 
				@WebInitParam(name = "a", value = "AAA"), //corresponds to <init-param>,<param-name>,<param-value>
				@WebInitParam(name = "b", value = "BBB")
		})
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ServletConfig config=getServletConfig();
		out.println("<html><body>");
		out.println("<h1>Initialization Parameter Details</h1>");
		out.println("<h2>");
		out.println("a--->"+config.getInitParameter("a")+"<br>");
		out.println("b--->"+config.getInitParameter("b")+"<br>");
		out.println("</h2></body></html>");
	}
	static
	{
		System.out.println("Servlet Loading....");
	}
	public TestServlet() {
		System.out.println("Servlet Instantiation....");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialization....");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet Deinstantiation...");
	}
}
