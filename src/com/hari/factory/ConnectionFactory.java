package com.hari.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static Connection con;
	static
	{
		try
		{
			String url="jdbc:mysql://127.0.0.1:3306/dao";
			String user="root";
			String password="saibaba330";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getConnect()
	{
		return con;
	}

}
