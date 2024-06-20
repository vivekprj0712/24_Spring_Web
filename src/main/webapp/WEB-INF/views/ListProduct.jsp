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
	<h2>List Product</h2>
	<%
	List<EProductBean> products = (List<EProductBean>) request.getAttribute("products");
	%>
	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Qty</th>
			<th>Price</th>
		</tr>
		<%
			for(EProductBean product : products){
				out.println("<tr>");
				out.println("<td>"+product.getProductId()+"</td>");
				out.println("<td>"+product.getProductName()+"</td>");
				out.println("<td>"+product.getCategory()+"</td>");
				out.println("<td>"+product.getQty()+"</td>");
				out.println("<td>"+product.getPrice()+"</td>");
				out.println("</tr>");
			}
		%>
		
	</table>
</body>
</html>