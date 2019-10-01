package com.ashsoft.factory;

import com.ashsoft.service.StudentService;
import com.ashsoft.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService stdService;
	static
	{
		stdService=new StudentServiceImpl();
	}
	public static StudentService getStudentService()
	{
		return stdService;
	}
}
