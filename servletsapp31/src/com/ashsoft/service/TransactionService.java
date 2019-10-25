package com.ashsoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionService {
    
	 Connection con=null;
	 Statement st=null;
	 ResultSet rs=null;
     public TransactionService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ashish");
			st=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public String deposit(String accNo,int depAmt)
    {
    	String status="";
    	try {
			int rowCount=st.executeUpdate("update account set ACCBAL=ACCBAL+'"+depAmt+"' where ACCNO='"+accNo+"'");
			if(rowCount==1)
			{
				status="success";
			}
			else
			{
				status="failure";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
    	return status;
    }
    
    public int getTotalBalance(String accNo)
    {
    	int totalBalance=0;
    	try {
			rs=st.executeQuery("select * from account where ACCNO='"+accNo+"'");
			rs.next(); //moves cursor to first record
			totalBalance=rs.getInt("ACCBAL");  //getting balance from RS
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return totalBalance; //returns balance to the servlet
    }
}