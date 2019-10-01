package com.ashsoft.dao;

import com.ashsoft.dto.Student;

public interface StudentDao {
	public String add(String sid,String sname,String saddr);
	public Student search(String sid);
	public String update(String sid,String sname,String saddr);
	public String delete(String sid);
}
