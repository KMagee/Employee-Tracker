package com.avaya.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

public class EmployeeDbUtil extends DBConnection {
	
	
	
	

	public List<Employee> getEmployees() throws Exception {
		
		// method will return a list array of employees, create empty list here to populate with the result set below
		
		List<Employee> employees = new ArrayList<>();
		
		
		//JDBC Objects
		
		//Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			//get a DB connection
			//driver details
//			Class.forName("com.mysql.jdbc.Driver");
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-tracker?useSSL=false", "employee", "employee");
			
			//sql to return all employees 
			String sql = "Select * from employee order by last_name";
			
			myStmt = getConnection().createStatement();
			
			//result set
			myRs = myStmt.executeQuery(sql);
			
			
			//Loop over the result set and create new employee objects for each row returned
			
			while(myRs.next()) {
				
				//get the data
				
				 int id = myRs.getInt("id");
				 String firstName= myRs.getString("first_name");
				 String lastName = myRs.getString("last_name");
				 String email= myRs.getString("email");
				 String department= myRs.getString("department");
				
				// create the employee object and add to the array list
				 
				 Employee tempemployee = new Employee(id,firstName,lastName,email,department);
				 
				 // add it to the array to send back to the calling servlet
				 employees.add(tempemployee);
				 
				 
			}		
			
		}
		
		
		catch(Exception exc){ exc.printStackTrace(); };
				return employees;	
	}

	public void addEmployee(Employee theEmployee) {
	
		//method takes param of new employee object to be added
		
		//jdbc objects
		//Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
		
	
			//get a DB connection
			//driver details
//			Class.forName("com.mysql.jdbc.Driver");
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-tracker?useSSL=false", "employee", "employee");	
			
			//write the sql
			String sql = "Insert into employee (first_name, last_name, email, department) values (?,?,?,?)";
			
			//prepare the stmt
			
			myStmt = getConnection().prepareStatement(sql);
			
			//set the params, get the data from the employee object created in servlet
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setString(4, theEmployee.getDepartment());	
			
			// add the new employee
			myStmt.execute();
			
		}
		
		catch(Exception exc){ exc.printStackTrace(); };
				
	}

	public Employee loadEmployee(String theEmployeeId) {
		
		
		Employee theEmployee = null;
		
		//jdbc objects
		//Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int employeeId;
		
		try {
			
			//convert id to int
			employeeId = Integer.parseInt(theEmployeeId);
			
			//get a DB connection
			//driver details
//			Class.forName("com.mysql.jdbc.Driver");
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-tracker?useSSL=false", "employee", "employee");	
			
			//sql to get the selected student
			
			String sql="select * from employee where id=?";
			
			//create the prepareed statement
			
			myStmt = getConnection().prepareStatement(sql);
			
			//set params
			myStmt.setInt(1, employeeId );
			
			
			//execute statement
			
			myRs = myStmt.executeQuery();
			
			//retrieve data from the result set row, create new object
			
			while(myRs.next()) {
			
			 int id = myRs.getInt("id");
			 String firstName= myRs.getString("first_name");
			 String lastName = myRs.getString("last_name");
			 String email= myRs.getString("email");
			 String department= myRs.getString("department");
			
				
			//use the studentID in the constructor to create a new student object
				theEmployee = new Employee(id,firstName,lastName,email,department);	
			
			}
			
		}
		
	
		catch(Exception exc){ exc.printStackTrace(); };
		
		
		return theEmployee;
	}

	public void updateEmployee(Employee theEmployee) throws Exception{
		//jdbc objects
		//Connection myConn = null;
		PreparedStatement myStmt = null;
		
	
		try {
		//get DB Connection
//		Class.forName("com.mysql.jdbc.Driver");
//		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-tracker?useSSL=false", "employee", "employee");
		
		
		//sql
		String sql = "Update employee set first_name=?,last_name=?,email=?,department=? where id=?";
		
		
		//prepare stmt
		
		myStmt = getConnection().prepareStatement(sql);
		
		
		//set statement params using the employee object passed in from the controller servlet
		
		myStmt.setString(1, theEmployee.getFirstName());
		myStmt.setString(2, theEmployee.getLastName());
		myStmt.setString(3, theEmployee.getEmail());
		myStmt.setString(4, theEmployee.getDepartment());
		//where
		myStmt.setInt(5,theEmployee.getId());
		
		
	
		// execute the update stmt
		myStmt.execute();		
		}
		catch(Exception exc){ exc.printStackTrace(); };
		
		
	}

	public void deleteEmployee(String theEmployeeId) throws Exception {
		
		
		
		//jdbc objects
		//Connection myConn = null;
		PreparedStatement myStmt = null;
		int employeeId; 
		
		try {
			
			employeeId = Integer.parseInt(theEmployeeId);
			
			//get DB Connection
//			Class.forName("com.mysql.jdbc.Driver");
//			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee-tracker?useSSL=false", "employee", "employee");
			
			
			//sql 
			String sql = "Delete from employee where id=?";
			
			//prepare stmt;
			
			myStmt = getConnection().prepareStatement(sql);
			
			//set params
			
			myStmt.setInt(1,employeeId);
			
			//execute statement
			myStmt.execute();
			
		}
		
		catch(Exception exc){ exc.printStackTrace(); };
			
	}
	
	
}
