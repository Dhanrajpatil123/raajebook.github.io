package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/ebookapp";
			
			String user = "root";
			
			String password = "Dhanraj@143";
			
			
			con = DriverManager.getConnection(url,user,password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	

}

