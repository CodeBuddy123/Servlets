package com.ashsoft.service;

import com.ashsoft.dao.StudentDao;
import com.ashsoft.dto.Student;
import com.ashsoft.factory.StudentDaoFactory;

public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(String sid, String sname, String saddr) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		String status=stdDao.add(sid, sname, saddr);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		Student std=stdDao.search(sid);
		return std;
	}

	@Override
	public Student getStudent(String sid) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		Student std=stdDao.search(sid);
		return std;
	}

	@Override
	public String updateStudent(String sid, String sname, String saddr) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		String status=stdDao.update(sid, sname, saddr);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		StudentDao stdDao=StudentDaoFactory.getStudentDao();
		String status=stdDao.delete(sid);
		return status;
	}

}
