<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>

<form action="saveuser" method="Post">
	FirstName:<input type="text" name="firstName"><br>
	LastName:<input type="text" name="lastName"><br>
	Email:<input type="text" name="email"><br>
	Password:<input type="password" name="password"><br>
	ConfirmPassword:<input type="password" name="confirmPassword"><br>
	<input type="submit" value="Signup">
	
</form>

</body>
</html>