package com.hari.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.hari.dto.Student;
import com.hari.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {
	
	Connection con1 = ConnectionFactory.getConnect();
	PreparedStatement pst = null;
	ResultSet rs = null;
	Student s = new Student();
	Scanner sc = new Scanner(System.in);
	String status = "";

	@Override
	public String add(Student std) {
		System.out.println("Dao");
		try {
			String sql = "select*from studentdao where sid=?";
			pst = con1.prepareStatement(sql);
			pst.setString(1, std.getSid());
			rs = pst.executeQuery();
			boolean b = rs.next();
			if (b == true)
				status = "existed";
			else {
				String sql1 = "insert into studentdao (sid,sname,scity)values(?,?,?)";
				pst = con1.prepareStatement(sql1);
				System.out.println(s.getSid()+" "+s.getSname()+" "+s.getScity());
				pst.setString(1, std.getSid());
				pst.setString(2, std.getSname());
				pst.setString(3, std.getScity());
				int i = pst.executeUpdate();
				if (i > 0)
					status = "Success";
				else
					status = "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "fail";
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student s=new Student();
		try {
			System.out.println("Dao");
			String sql = "select*from studentdao where sid=?";
			pst = con1.prepareStatement(sql);
			pst.setString(1, sid);
			rs = pst.executeQuery();
			boolean val=rs.next();
			if(val==true)
			{
				s.setSid(rs.getString(1));
				s.setSname(rs.getString(2));
				s.setScity(rs.getString(3));
			}
			else if(val==false)
			{
				s=null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String delete(String sid) {
		String status="";
		try
		{
			String sql="delete from studentdao where sid=?";
			pst = con1.prepareStatement(sql);
			pst.setString(1, sid);
			int k=pst.executeUpdate();
			if(k==1)
				status="success";
			else
				status="fail";
		}
		catch(Exception e)
		{
			status="fail";
			e.printStackTrace();
		}

		return status;
	}

}
