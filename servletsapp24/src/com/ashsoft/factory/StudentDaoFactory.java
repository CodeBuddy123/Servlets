package com.ashsoft.factory;

import com.ashsoft.dao.StudentDao;
import com.ashsoft.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao stdDao;
	static
	{
		stdDao=new StudentDaoImpl();
	}
	public static StudentDao getStudentDao()
	{
		return stdDao;
	}
}
