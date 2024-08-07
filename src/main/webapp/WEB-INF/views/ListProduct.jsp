<%@page import="java.util.List"%>
<%@page import="com.Bean.EProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%--  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<html>
<head>
<meta charset="ISO-8859-1">	
<title>List Product</title>
</head>
<body>
	<a href="/newproduct">New Product</a>
	<a href="/productname">Delete By Product Name</a>
	<h2>List Product</h2>
	<%
	List<EProductBean> products = (List<EProductBean>) request.getAttribute("products");
	%>
	
	<a href ="ehome">Home Page</a><br><br>
	<a href ="logout">Logout</a><br><br>	
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Qty</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<%
			for(EProductBean product : products){
				out.println("<tr>");
				out.println("<td>"+product.getProductId()+"</td>");
				out.println("<td>"+product.getProductName()+"</td>");
				out.println("<td>"+product.getCategory()+"</td>");
				out.println("<td>"+product.getQty()+"</td>");
				out.println("<td>"+product.getPrice()+"</td>");
				out.println("<td><a href = 'deleteproduct?productId="+product.getProductId() +"'>Delete</a> | <a href = 'viewproduct?PRODUCTID="+product.getProductId() +"'>View</a></td>");
				out.println("</tr>");
			}
		%>
		
	</table>
</body>
</html>