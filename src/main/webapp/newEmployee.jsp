<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Employee</title>
	</head>
	<body>
		<h1>New Employee</h1>
		
		<form action="/gerenciadorJson/newEmployee" method="post">
			
			<label>Name:</label>
			<input type="text" name="name" />
			
			<label>Department:</label>
			<input type="text" name="department" />
			
			<label>Salary:</label>
			<input type="text" name="salary" />
			
			<button>Save</button>
		</form>
	</body>
</html>