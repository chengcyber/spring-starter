<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Custom Registration Form</title>
	<style>
		.error {
			color: red;
		}
	</style>
</head>
<body>

Fill out the form. Asterisk(*) means required.

	<form:form action="processForm" modelAttribute="customer">
		
		First name: <form:input path="firstName" />
		
		<br />
		
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error" /> 
	
		<br />
		
		<input type="submit" value="submit" />
	
	</form:form>

</body>
</html>