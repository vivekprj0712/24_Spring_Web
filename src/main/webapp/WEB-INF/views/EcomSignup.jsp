<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="esignup" method = "post" enctype="multipart/form-data">

	UserName :<input type="text" name = "userName"><br><br>
	Email : <input type="text" name = "email"><br><br>
	Password :<input type="password" name =  "password"><br><br>
	Profile Image:<input type="file" name="profilePic"><br><br>
	<input type="submit" value = "Signup">
	
</form>

</body>
</html>