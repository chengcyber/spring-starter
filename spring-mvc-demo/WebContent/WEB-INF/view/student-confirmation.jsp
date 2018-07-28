<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Confirmation</title>
</head>
<body>

<!-- automatically invoke getter method -->
The student is confirmed: ${student.firstName} ${student.lastName}

<br />

Country: ${student.country}

<br />

Favorite Language: ${student.favoriteLanguage}

<br />

Operating Systems: 

<ul>
  <c:forEach var="os" items="${student.operatingSystems}">
    <li>${ os }</li>
  </c:forEach>
</ul>

<br />

</body>
</html>