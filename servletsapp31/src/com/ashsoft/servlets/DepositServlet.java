package com.ashsoft.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ashsoft.service.TransactionService;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int depAmt=Integer.parseInt(request.getParameter("depAmt"));
			String depName=request.getParameter("depName");            //getting present request data
			
			HttpSession hs=request.getSession();
			
			String accNo=(String) hs.getAttribute("accNo");
			String accName=(String) hs.getAttribute("accName");
			String accType=(String) hs.getAttribute("accType");       //getting previous request data
			String accBranch=(String) hs.getAttribute("accBranch");
			
			TransactionService txService= new TransactionService();
			String status=txService.deposit(accNo, depAmt);     //calling Service method to perform deposit operation
			int totalBalance=txService.getTotalBalance(accNo);  //calling Service method to get total balance
			
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();  //Displaying details
			out.println("<html><body>");
			out.print("<h2 style='color:red' align='center'>Ashish Banking Services</h2>");
			out.print("<h3 style='color:blue' align='center'>Transaction Details</h2>");
			out.println("<center>");
			out.println("<table border='1' bgcolor='lightblue'>");
			out.println("<tr><td>Account No</td><td>"+accNo+"</td></tr>");
			out.println("<tr><td>Account Name</td><td>"+accName+"</td></tr>");
			out.println("<tr><td>Account Type</td><td>"+accType+"</td></tr>");
			out.println("<tr><td>Account Branch</td><td>"+accBranch+"</td></tr>");
			out.println("<tr><td>Deposit Amount</td><td>"+depAmt+"</td></tr>");
			out.println("<tr><td>Depositor Name</td><td>"+depName+"</td></tr>");
			out.println("<tr><td>Transaction Status</td><td>"+status+"</td></tr>");
			out.println("<tr><td>Total Balance</td><td>"+totalBalance+"</td></tr>");
			out.println("</table</center></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
