<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  background: linear-gradient(to top right, #000066 0%, #ccccff 62%);
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

.ss{
	color:#000000  ;
}
	</style>
</head>
<body>
	<%
		String id = request.getParameter("id");
	  	String month = request.getParameter("month");
		String year = request.getParameter("year");
		String hours = request.getParameter("hours");
		String hour_pay = request.getParameter("hour_pay");
		String full_pay = request.getParameter("full_pay");
		String empl_id = request.getParameter("empl_id");
		
	%>
		<div class ="ss">
		<h1>Upadate Employee Salary</h1>
		</div>
	<form action ="update-sallary" method= "post">
	
		<label>Sallary ID:<input type="text" name ="sal_id" value ="<%=id%>" readonly></label><br>
		<label>Month<input type ="text" name = "month" value ="<%= month%>"></label><br>
		<label>Year<input type ="text" name = "year" value = "<%= year%>"></label><br>
		<label>hour<input type="text" name = "hour" value="<%=hours%>"></label><br>
		<label>one OT Hour for pay<input type ="text" name = "hour_pay" value="<%=hour_pay %>"></label><br>
		<label>Full Salary<input type="text" name = "full_pay" value="<%= full_pay%>"></label><br>
		<label>Employee_id<input type="text" name = "empl_id" value="<%= empl_id%>"readonly></label><br>
		 
		<input type="submit" name="submit"value="Update">
		
		
	</form>
</body>
</html>