package com.ashsoft.service;

import com.ashsoft.dto.Student;

public interface StudentService {
	public Student getStudent(String sid);
	public String update(String sid,String sname,String saddr);
}
