<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<form action="saveproduct" method = "post" enctype="multipart/form-data">
		ProductName:<input type="text" name="productName">
		Category:<input type="text" name="category">
		Qty:<input type="text" name="qty">
		Price<input type="text" name="price">
		ProductImage:<input type="file" name="productPic">
		<input type="submit" value = "Add Product">
	</form>
</body>
</html>