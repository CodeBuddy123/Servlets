package com.ashsoft.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.ashsoft.dto.Student;
import com.ashsoft.factory.ConnectionFactory;

public class StudentServiceImpl implements StudentService {
	String status="";
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;

	
	public Student getStudent(String sid)
	{
		Student std=null;
		try {
			 con=ConnectionFactory.getConnection();
			 pst=con.prepareStatement("select * from studentinfo where SID = ?");
			 pst.setString(1,sid);
			 rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true)
			{
				std=new Student();             
				std.setSid(rs.getString("SID")); //transferring data from ResultSet to Student object
				std.setSname(rs.getString("SNAME"));
				std.setSaddr(rs.getString("SADDR"));
			}
			else
			{
				std=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	public String update(String sid,String sname,String saddr)
	{
		String status="";
		try {
			con=ConnectionFactory.getConnection();
			pst=con.prepareStatement("update studentinfo set SNAME = ? ,SADDR = ? where SID = ?");
			pst.setString(1,sname);
			pst.setString(2, saddr);
			pst.setString(3, sid);
			int rowCount=pst.executeUpdate();
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
}
