<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<h2>Welcome , ${user.userName}</h2>
	<img alt="" src="${user.profilePath}" width="100px" height="100px" >
	
	<a href="listuserproduct">Products</a>
</body>
</html>