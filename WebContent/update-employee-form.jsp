<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Employee Tracker</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Employee</h3>
		
		<!-- form submit request to the controller servlet using GET-->
		<form action="EmployeeControllerServlet" method="GET">
		
			<!-- Pass this hidden value  UPDATE command to the servlet, use in the switch statement to get the UPDATE method  -->
			<input type="hidden" name="command" value="UPDATE"/>
			
			<input type="hidden" name="employeeId" value="${THE_EMPLOYEE.id}"/>
			
			<!-- Not including ID in the new emp form as this value is created by the DB -->
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" name="firstName" value="${THE_EMPLOYEE.firstName}"/></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" name="lastName" value="${THE_EMPLOYEE.lastName}"/></td>
					</tr>
					<tr> 
						<td><label>Email:</label></td>
						<td><input type="text" name="email" value="${THE_EMPLOYEE.email}"/></td>
					 </tr>	
					<tr>
						<td><label>Department:</label></td>
						<td><input type="text" name="department" value="${THE_EMPLOYEE.department}"/></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td> 
					
					</tr>

				</tbody>
						
			</table>

		</form>
		
		<div style="clear : both;"></div>
		
		<p><a href="EmployeeControlServlet">Back to List</a></p>
		
	</div>
	

</body>
</html>