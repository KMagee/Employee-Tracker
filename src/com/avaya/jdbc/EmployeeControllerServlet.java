package com.avaya.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmployeeControllerServlet")
public class EmployeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//create ref to the DBUtil to get the data from DB using the methods in that class
	private EmployeeDbUtil employeeDbUtil = new EmployeeDbUtil();

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//try/catch to handle the Throw Exceptions from the methods
		try {
			
			/*READ THE INCOMING REQUEST COMMAND FROM THE FORM 
			AND ROUTE TO THE APPROPRIATE METHOD*/
			
			//form value=command or embedded in url links
			String theCommand = request.getParameter("command");
			
			
			//default to the main list all employees
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			//switch stmt to route the command to the right method
			
			switch(theCommand) {
			
			case "LIST":
			//method call to list all the employees, main display
			listEmployees(request, response);
			break;
			
			//from the add-employee-form --> name="command" value="ADD".
			case "ADD":
			addEmployee(request, response);
			break;
			
			
			//from the update link in the main page, used to pre-populate the employee update form for a chosen employee 
			case "LOAD":
			loadEmployee(request, response);
			break;
			
			//from the update-employee.jsp form submit, call the update method
			//<input type="hidden" name="command" value="UPDATE"/>
			case "UPDATE":
			updateEmployee(request,response);
			break;
			
			//from the delete URL -- <c:param name="command" value="DELETE"/>
			case "DELETE":
			deleteEmployee(request,response);
			break;
			
			
			
			default:
				listEmployees(request, response);
			
			}//end of switch
			
			
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	
	}



	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get the ID of the employee to be deleted
		
		String theEmployeeId = request.getParameter("employeeID");
		
		//send the ID to the DB Util and call the delete method
		employeeDbUtil.deleteEmployee(theEmployeeId);
	
		
		//return to the main list of employees
		listEmployees(request, response);
		
	}



	private void updateEmployee(HttpServletRequest request , HttpServletResponse response) throws Exception {
		// get the form data
		
		//need to parse to an int to create the employee object
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		
		
		
		//create employee object using the constructor with id, pass to the dbutil
		 Employee theEmployee = new Employee(id,firstName,lastName,email,department);
		 
	
		 //update the DB 
		employeeDbUtil.updateEmployee(theEmployee);
		 
		
		//return to the main list with updated info
		listEmployees(request, response);
	}



	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get the employee ID that was embedded in the URL, <c:param name="employeeID"
		
		String theEmployeeId = request.getParameter("employeeID");
		
		//get the data from the DB for that ID
		
		Employee theEmployee = employeeDbUtil.loadEmployee(theEmployeeId);
		
		//add the employee object returned from dbutil to the request object
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
	
		//pass request to the update form
		RequestDispatcher dispatcher  = request.getRequestDispatcher("/update-employee-form.jsp");
		dispatcher.forward(request, response);
		
	}



	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read the form data from add-employee-form.jsp
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		
		
		//create new employee object - using constructor method without the id, this is created in the DB
		Employee theEmployee = new Employee(firstName,lastName,email,department);
		
		
		//add the new employee to the database
		
		employeeDbUtil.addEmployee(theEmployee);
		
		
		//return back to the main list
		listEmployees(request,response);
	}



	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1. GET DATA get list of employees from the DB	Util	
		List<Employee> employees = employeeDbUtil.getEmployees();
			
			
			//2. ADD TO THE REQUEST add the employee list as an attribute to the request object
			request.setAttribute("EMPLOYEE_LIST", employees);
			
			//3. SEND TO THE JSP. sends request, response objects to the  View jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list-employees.jsp");
			dispatcher.forward(request, response);
			
		
	}
}
