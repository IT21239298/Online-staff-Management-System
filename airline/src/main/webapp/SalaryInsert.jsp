<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.airline.entities.Employee"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
		body {
  width: 100%;
  height: 100vh;
  margin: 0;
  background-color: #1b1b32;
	color: #f5f6f7;
  font-family: Tahoma;
	font-size: 16px;
}

h1, p {
  margin: 1em auto;
  text-align: center;
}

form {
  width: 60vw;
	max-width: 500px;
	min-width: 300px;
	margin: 0 auto;
  padding-bottom: 2em;
}

fieldset {
  border: none;
	padding: 2rem 0;
}

fieldset:not(:last-of-type) {
  border-bottom: 3px solid #3b3b4f;
}

label {
  display: block;
	margin: 0.5rem 0;
}

input,
textarea,
select {
  margin: 10px 0 0 0;
	width: 100%;
  min-height: 2em;
}

input, textarea {
  background-color: #0a0a23;
  border: 1px solid #0a0a23;
  color: #ffffff;
}

.inline {
  width: unset;
  margin: 0 0.5em 0 0;
  vertical-align: middle;
}

input[type="submit"] {
  display: block;
  width: 60%;
  margin: 1em auto;
  height: 2em;
  font-size: 1.1rem;
  background-color: #3b3b4f;
  border-color: white;
  min-width: 300px;
}

input[type="file"] {
  padding: 1px 2px;
}

a {
  color: #dfdfe2;
}


	</style>
</head>
<body>
	<h1>Insert Salary for Employee</h1>
	

	<p></p>

	<form action="salary-insert" method="post">
		 
		<label for="cars">Choose Employee name:</label>
		

		<select name="empID">
			<%
			ArrayList<Employee> emp = (ArrayList<Employee>) request.getAttribute("employeeList");
			for (Employee e : emp) {
			%>
			<%-- Arranging data in tabular form
        --%>

			<option value="<%=e.getId()%>"><%=e.getName()%></option>

			<%}%>
		</select>
	
		<br> <label>Year<input type="text" name="year"></label><br>
		<label> Hours<input type="text" name="month"></label><br>
		<label> month<input type="text" name="hours"></label><br> 
		 <label>One hour for pay<input type="text" name="hour-pay"></label><br> 
		<label> Salary<input type="text" name="salary"></label><br>
		<label> Enter full salary<input type="text" name=emp.id></label> <br>
		
		 <input type="submit" name="submit"value="Enter Salary">
	</form>
</body>
</html>