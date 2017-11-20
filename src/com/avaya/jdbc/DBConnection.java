package com.avaya.jdbc;

import java.sql.DriverManager;

public class DBConnection {

	private String username = "employee";
	private String password = "employee";
	private String hostname = "localhost";
	private String port = "3306";
	private String database = "employee-tracker?useSSL=false";
	private String classname = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
	private java.sql.Connection con;
	

	
	public DBConnection () {
		
		try {
			
			Class.forName(classname);
			con = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	public java.sql.Connection getConnection() {
		return con;
	}
}
