package com.hari.factory;

import com.hari.dao.StudentDao;
import com.hari.dao.StudentDaoImpl;

public class StudentDaoFactory {
	private static StudentDao studentdao;
	static
	{
		studentdao=new StudentDaoImpl();
	}
	public static StudentDao getStudentDao()
	{
		return studentdao;
	}

}
