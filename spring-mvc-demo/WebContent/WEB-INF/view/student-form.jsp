<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

	<!-- automatically invoke setter and getter in model attribute student -->

	First name: <form:input path="firstName" />
	<br />
	
	Last name: <form:input path="lastName" />
	<br />
	
	Country: 
	<form:select path="country">
		<form:option value="Brazil" label="Brazil" />
		<form:option value="France" label="France" />
		<form:option value="Germany" label="Germany" />
		<form:option value="India" label="India" />
	</form:select>
	<br />
	
	<input type="submit" value="Submit" />
	
</form:form>

</body>
</html>