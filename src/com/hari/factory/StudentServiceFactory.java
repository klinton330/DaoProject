package com.hari.factory;

import com.hari.service.StudentService;
import com.hari.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentservice;
	static
	{
		studentservice=new StudentServiceImpl();
	}
	public static StudentService getStudentService()
	{
		return studentservice;
	}

}
