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
		 <c:if test="${not empty employeeName}">
            Employee <c:out value="${employeeName}" /> cadastrado com sucesso!
    	</c:if>
		<ul>
	        <c:forEach items="${employees}" var="e">
	            <li><c:out value="${e.name}" /> <a href="/gerenciadorJson/removeEmployee?id=<c:out value="${e.id}" />">delete</a> <a href="/gerenciadorJson/renameEmployee?id=<c:out value="${e.id}" />">rename</a> </li>
	        </c:forEach>
   		</ul>
	</body>
</html>