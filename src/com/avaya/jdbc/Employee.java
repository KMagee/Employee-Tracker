package com.avaya.jdbc;

public class Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String department;

	

	//DB auto creates ID, CONSTRUCTOR without ID -creating new emps
	public Employee(String firstName, String lastName, String email, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
	}

	//DB auto creates ID, CONSTRUCTOR with all fields, for updates
	
	public Employee(int id, String firstName, String lastName, String email, String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
	}

	
	//GETTERS AND SETTERS FOR EMPLOYEE
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}








