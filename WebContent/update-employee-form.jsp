<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- adding JSTL instead of using scriplets in the JSP -->   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-employee-style.css">

<style>
.showError {display:inline;
}


.hideError {display:none;
}

</style>

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
		<form action="EmployeeControllerServlet" method="get">
		
			<!-- Pass this hidden value  UPDATE command to the servlet, use in the switch statement to get the UPDATE method  -->
			<input type="hidden" name="command" value="UPDATE"/>
			
			<!-- Not including ID in the new emp form as this value is created by the DB -->
			<table>
				<tbody>
					<tr>
						<td><label>Employee ID:</label></td>
						<td><input type="text" id="employeeId" name="employeeId" value="${THE_EMPLOYEE.id}" readonly/></td>
					</tr>
					<tr>
						<td><label>First Name:</label></td>
						<td><input type="text" id="firstName"  name="firstName" value="${THE_EMPLOYEE.firstName}" autofocus/><span class='hideError' id='msgUsernameError'>Please enter First Name. Must be between 1 & 20 alphabetic characters</span></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><input type="text" id="lastName" name="lastName" value="${THE_EMPLOYEE.lastName}"/><span class='hideError' id='msgLastNameError'>Please enter Last Name. Must be between 1 & 20 alphabetic characters</span></td>
					</tr>
					<tr> 
						<td><label>Email:</label></td>
						<td><input type="text" id="email"  name="email" value="${THE_EMPLOYEE.email}"/><span class='hideError' id='msgEmailError'>Please enter email. Must contain only alphanumeric chars and end with @avaya.com</span></td>
					 </tr>	
					<tr>
						<td><label>Department:</label></td>
						<td><select name="department" id="department">
							 <option value="${THE_EMPLOYEE.department}">${THE_EMPLOYEE.department}</option> 
							
							<c:choose>
							
							 <c:when test="${THE_EMPLOYEE.department == 'Marketing'}">
							  <option value="HR">HR</option>
							  <option value="Finance">Finance</option>
							  <option value="IT">IT</option>
							</c:when>
						
						
							<c:when test="${THE_EMPLOYEE.department == 'HR'}">
							  <option value="Marketing">Marketing</option>
							  <option value="Finance">Finance</option>
							  <option value="IT">IT</option>
							</c:when>
							
							
							<c:when test="${THE_EMPLOYEE.department == 'Finance'}">
							  <option value="Marketing">Marketing</option>
							  <option value="HR">HR</option>
							  <option value="IT">IT</option>
							</c:when>
							
							
							<c:when test="${THE_EMPLOYEE.department == 'IT'}">
							  <option value="Marketing">Marketing</option>
							  <option value="HR">HR</option>
							  <option value="Finance">Finance</option>
							</c:when>
												
						
							</c:choose>
						
					
						</select> 
						</td>
					<!--<td><input type="text" name="department" value="${THE_EMPLOYEE.department}"/></td>  -->	
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input id="saveBtn"  type="submit" value="Save" class="save"/></td> 
					
					</tr>

				</tbody>
						
			</table>

		</form>
		
		<div style="clear : both;"></div>
		
		<p><a href="EmployeeControllerServlet">Back to List</a></p>
		
	</div>
	
<script src="js/updateEmployeeFormValidation.js"></script>

</body>
</html>