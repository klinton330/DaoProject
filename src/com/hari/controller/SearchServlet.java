package com.hari.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hari.dto.Student;
import com.hari.factory.StudentServiceFactory;
import com.hari.service.StudentService;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sno");
		StudentService ss=StudentServiceFactory.getStudentService();
		RequestDispatcher rd=null;
		Student s1=ss.searchStudent(sid);
		if(s1!=null)
		{
		request.setAttribute("display", s1);
	    rd=request.getRequestDispatcher("Display.jsp");
		rd.forward(request, response);
		}
		else if(s1==null)
		{
			rd=request.getRequestDispatcher("fail.jsp");
			rd.forward(request, response);
		}
	}

}
