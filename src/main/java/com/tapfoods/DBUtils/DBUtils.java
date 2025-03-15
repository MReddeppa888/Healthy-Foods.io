package com.tapfoods.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils 
{
	private static String Url="jdbc:mysql://localhost:3306/tap_foods";
	private static String UserName="root";
	private static String Password="root";
	private static Connection con=null;
	
	
	
	
	public static  Connection connect() throws ClassNotFoundException, SQLException  
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		 //System.out.println("Driver is loaded");
		 
		 con=DriverManager.getConnection(Url,UserName,Password);
		 //System.out.println("connection to Database is estableshed ");
		return con;
	}
}
