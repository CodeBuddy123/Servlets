package com.ashsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ashsoft.dto.Student;
import com.ashsoft.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(String sid, String sname, String saddr) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from students where SID = ?");
			pst.setString(1,sid);
			ResultSet rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true)
			{
				status="existed";
			}
			else
			{
				pst=con.prepareStatement("insert into students values(?,?,?)");
				pst.setString(1,sid);
				pst.setString(2,sname);
				pst.setString(3, saddr);
				int rowCount=pst.executeUpdate();
				if(rowCount==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student std=null;
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from students where SID = ?");
			pst.setString(1,sid);
			ResultSet rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true)
			{
				std=new Student();
				std.setSid(rs.getString("SID"));
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

	@Override
	public String update(String sid, String sname, String saddr) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("update students set SNAME = ?, SADDR = ? where SID = ?");
			pst.setString(3, sid);
			pst.setString(1,sname);
			pst.setString(2,saddr);
			
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

	@Override
	public String delete(String sid) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from students where SID = ?");
			pst.setString(1, sid);
			ResultSet rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true)
			{
				pst=con.prepareStatement("delete from students where SID = ?");
				pst.setString(1, sid);
				int rowCount=pst.executeUpdate();
				if(rowCount==1)
				{
					status="success";
				}
				else
				{
					status="failure";
				}
			}
			else
			{
				status="not existed";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
}
