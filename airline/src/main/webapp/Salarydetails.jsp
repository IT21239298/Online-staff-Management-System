<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.airline.entities.Sallary"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<h1>Sallary Details</h1>
		
		<style>
			body {
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  line-height: 1.42em;
  color:#ccccff;
  background-color:#00004d;
}

h1 {
  font-size:3em; 
  font-weight: 300;
  line-height:1em;
  text-align: center;
  color: #4DC3FA;
}

h2 {
  font-size:1em; 
  font-weight: 300;
  text-align: center;
  display: block;
  line-height:1em;
  padding-bottom: 2em;
  color: #FB667A;
}

h2 a {
  font-weight: 700;
  text-transform: uppercase;
  color: #FB667A;
  text-decoration: none;
}

.blue { color:  #b3ffff; }
.yellow { color: #FFF842; }

.container th h1 {
	  font-weight: bold;
	  font-size: 15px;
  text-align: left;
  color:#99ffdd;
}

.container td {
	  font-weight: normal;
	  font-size: 1em;
  -webkit-box-shadow: 0 2px 2px -2px #0E1119;
	   -moz-box-shadow: 0 2px 2px -2px #0E1119;
	        box-shadow: 0 2px 2px -2px #0E1119;
}

.container {
	  text-align: left;
	  overflow: hidden;
	  width: 100%;
	  margin: 0 auto;
  display: table;
  padding: 0 0 8em 0;
}

.container td, .container th {
	  padding-bottom: 2%;
	  padding-top: 2%;
  padding-left:2%;  
}

/* Background-color of the odd rows */
.container tr:nth-child(odd) {
	  background-color: #323C50;
}

/* Background-color of the even rows */
.container tr:nth-child(even) {
	  background-color: #2C3446;
}

.container th {
	  background-color: #1F2739;
}

.container td:first-child { color:#ffffff; }

.container tr:hover {
   background-color:  #9999ff;
-webkit-box-shadow: 0 6px 6px -6px #0E1119;
	   -moz-box-shadow: 0 6px 6px -6px #0E1119;
	        box-shadow: 0 6px 6px -6px #0E1119;
}

.container td:hover {
  background-color:#00e6e6;
  color: #403E10;
  font-weight: bold;
  
  
  transition-delay: 0s;
	  transition-duration: 0.4s;
	  transition-property: all;
  transition-timing-function: line;
}

@media (max-width: 100%) {
.container td:nth-child(4),
.container th:nth-child(4) { display: none; }
}
		
		</style>
	</head>
	<body>
	
	<section id="adddriver" class="py-5" style="background-color: #b2c0db;">
	<table class="container" border="1"  >
		
		<thead>
			<tr>
			     <th><h1>Sallary ID</h1></th>
				 <th><h1>Month</h1></th>
				 <th><h1>Year</h1></th>
				 <th><h1>OT Hours</h1></th>
				 <th><h1>One OT Hours for pay</h1></th>
				 <th><h1>Full Salary</h1></th>
				 <th><h1>Employee ID Number</h1></th>
				 <th><h1>Update</h1></th>
				 <th><h1>delete</h1></th>
				 
			</tr>
		</thead>	
		 
			<c:forEach var="esal" items="${employeeList}">
			 
				 <c:set var="id" value="${esal.sal_id}"/>
				 <c:set var="month" value="${esal.month}"/>
				 <c:set var="year" value="${esal.year}"/>
				 <c:set var="hours" value="${esal. hours}"/>
				  <c:set var="hour_pay" value="${esal.hour_pay}"/>
				  <c:set var="full_pay" value="${esal.full_pay}"/>
				   <c:set var="empl_id" value="${esal.empl_id}"/>
				  
				  
				  
		<c:url value="UpdateSalary.jsp" var="salupdate">
			<c:param name="id" value="${id}"/>
			<c:param name="month" value="${month}"/>
			<c:param name="year" value="${year}"/>
			<c:param name="hours" value="${hours}"/>
			<c:param name="hour_pay" value="${hour_pay}"/> 
			<c:param name="full_pay" value="${full_pay}"/>
			<c:param name="empl_id" value="${empl_id}"/>
		</c:url>
		
		<c:url value="deletSalary.jsp" var="salDelete">
			<c:param name="id" value="${id}"/>
			<c:param name="month" value="${month}"/>
			<c:param name="year" value="${year}"/>
			<c:param name="hours" value="${hours}"/>
			<c:param name="hour_pay" value="${hour_pay}"/> 
			<c:param name="full_pay" value="${full_pay}"/>
			<c:param name="empl_id" value="${empl_id}"/>
		
			</c:url>
		
					<tr>	
						
						<td>${esal.sal_id}</td>
						<td>${esal.month}</td>
						<td>${esal.year}</td>
						<td>${esal. hours}</td>
						<td>${esal. hour_pay}</td>
						<td>${esal.full_pay}</td>
						<td>${esal. empl_id}</td>
						<td>
							<a href="${salupdate}">
								<input type = "button" name="update" value="update Sallary details">
							</a>
						</td>
						<td>
							<a href="${salDelete}">
								<input type = "button" name="update" value="delete">
							</a>
						</td>
					</tr>	
				
				
			</c:forEach>
				
		</table>	
	</section>	
	
	
		
	</body>
</html>