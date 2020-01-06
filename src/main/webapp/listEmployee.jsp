<%@ page import="java.util.List, gerenciador.entity.Employee" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Employees</title>
	</head>
	<body>
		<h3>Employees: </h3>
		<ul>
	        <c:forEach items="${employees}" var="e">
	            <li><c:out value="${e.name}" /></li>
	        </c:forEach>
   		</ul>
	</body>
</html>