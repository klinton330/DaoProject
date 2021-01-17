package com.hari.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hari.dao.StudentDaoImpl;
import com.hari.dto.Student;
import com.hari.factory.StudentServiceFactory;
import com.hari.service.StudentService;
@WebServlet("/Controller")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	     protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		System.out.println(url);
		if (url.endsWith("Controller")) {
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String scity = request.getParameter("scity");
			Student std = new Student();
			std.setSid(sno);
			std.setSname(sname);
			std.setScity(scity);

			StudentService service = StudentServiceFactory.getStudentService();
			String status = service.addStudent(std);
			RequestDispatcher req = null;
			if (status.equalsIgnoreCase("success")) {
				req = request.getRequestDispatcher("success.jsp");
				req.forward(request, response);
			}
			if (status.equalsIgnoreCase("fail")) {
				req = request.getRequestDispatcher("fail.jsp");
				req.forward(request, response);
			}
			if (status.equalsIgnoreCase("existed")) {
				req = request.getRequestDispatcher("Existed.jsp");
				req.forward(request, response);
			}

		} 

	}

}
