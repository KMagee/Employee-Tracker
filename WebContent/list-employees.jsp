<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- adding JSTL instead of using scriplets in the JSP -->   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Tracker</title>

<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>

<div id="wrapper">

	<div id="header">

		<h2>Employee List</h2>
	</div>
</div>

<div id="container">
	<div id="content">
	
	<!-- Add in the button for New Employee, have event listener to redirect to the form-->
	<input type="button" value="Add Employee" id="myBtn" class="add-employee-button"/>
	

	<table>
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Department</th>
				<th>Action</th>
			</tr>
			
		<!-- 1. Use JSTL tags c:ForEach to loop over the EMPLOYEES_LIST from the servlet
		 and create the table. JSTL will go into the request object 
		 and get the list attribute and make it available.
		 JSP expression language, using the Employee Getters to retrieve the data e.g. tempEmployee.getId()-->
		<!-- 2. Use the JSTL Tag c:url to create an Update URL for each employee. This will take users to a new for. 
		    3. Use params to add the ID into this URL which will pass to the control servlet with the LOAD command, this will be used to get the data and prepopulate the form -->
		
		<c:forEach var="tempEmployee" items="${EMPLOYEE_LIST}">
		
		<!-- set up link for update url -->
		<c:url var ="updateLink" value="EmployeeControllerServlet">
				<c:param name="command" value="LOAD"/>
				<c:param name="employeeID" value="${tempEmployee.id}"/>
		
		</c:url>
		
		<!-- set up the link for the Delete url, embed the command and the chosen employee id to be sent to the servlet-->
		
		<c:url var ="deleteLink" value="EmployeeControllerServlet">
			<c:param name="command" value="DELETE"/>
			<c:param name="employeeID" value="${tempEmployee.id}"/>
		
		</c:url>
		
		
		
				<tr>
					<td> ${tempEmployee.id} </td>
					<td> ${tempEmployee.firstName} </td>
					<td> ${tempEmployee.lastName} </td>
					<td> ${tempEmployee.email} </td>
					<td> ${tempEmployee.department} </td>
					<td><a href="${updateLink}">Update</a> 
						 | 
						<a id="deleteLink" href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a></td>
				</tr>
		</c:forEach>
	</table>

	</div>
</div>

</body>

<script src="js/myBtn.js"></script>

</html>