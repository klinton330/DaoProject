package com.hari.service;

import com.hari.dao.StudentDao;
import com.hari.dto.Student;
import com.hari.factory.StudentDaoFactory;

public class StudentServiceImpl implements com.hari.service.StudentService {

	@Override
	public String addStudent(Student std) {
		System.out.println("service");
		StudentDao dao=StudentDaoFactory.getStudentDao();
		String status=dao.add(std);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		System.out.println("service");
		StudentDao dao=StudentDaoFactory.getStudentDao(); 
		Student s=dao.search(sid);
		return s;
	}

	@Override
	public String deleteStudent(String sid) {
		StudentDao dao=StudentDaoFactory.getStudentDao(); 
		String status=dao.delete(sid);
		return status;
	}

}
