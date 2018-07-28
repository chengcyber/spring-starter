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
		<form:options items="${countryOptions}" />
	</form:select>
	<br />
	
	Favorite Language:
	
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	
	<br />
	
	<input type="submit" value="Submit" />
	
</form:form>

</body>
</html>