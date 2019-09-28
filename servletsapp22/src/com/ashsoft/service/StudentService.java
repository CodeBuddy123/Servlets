package com.ashsoft.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ashsoft.dto.Student;

public class StudentService {
	Connection con;
	Statement st;
	ResultSet rs;
	public StudentService() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ashish");
			st=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
  
	public void addStudent(String sid,String sname,String saddr)
	{
		try {
			st.executeUpdate("insert into students values('"+sid+"','"+sname+"','"+saddr+"')"); //adds the student to the database
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Student> getStudents()
	{
		List<Student> stdList=new ArrayList<>();
		try {
			rs=st.executeQuery("select * from students"); //getting Students data from Database
			
			while(rs.next()) //going through each record in ResultSet
			{
				Student student=new Student();
				student.setSid(rs.getString("SID"));  //adding data from ResultSet to  StudentBean Object
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
				stdList.add(student);                //adding the StudentBean object to List
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stdList; //returning the list to Service Layer,which contains all the StudentBean Objects
	}
}
