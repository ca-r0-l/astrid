<%
	String employee = (String)request.getAttribute("employeeName");
	System.out.println(employee);
%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Employee saved</title>
	</head>
	<body>
		Employee ${ employee } cadastrado com sucesso!
	</body>
</html>