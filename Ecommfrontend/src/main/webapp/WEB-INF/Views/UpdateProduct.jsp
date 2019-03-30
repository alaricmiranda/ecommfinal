<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 align="center">Update Product Page</h3>

<form action="<c:url value="/updateProduct"/>" method="post">

<table align="center">
	<tr>
		<td>Product ID </td>
		<td><input type="text" id="productId" name="productId" value="${product.productid}" readonly/></td>
	</tr>
	<tr>
		<td>Product Name </td>
		<td><input type="text" id="productname" name="productname" value="${product.productname}"/></td>
	</tr>
	<tr>
		<td>Product Price </td>
		<td><input type="Number" id="price" name="price" value="${product.price}"/></td>
	</tr>
	<tr>
		<td>Product Quantity </td>
		<td><input type="text" id="quantity" name="quantity" value="${product.quantity}"/></td>
	</tr>
	<tr>
		<td>Product Detail </td>
		<td><input type="text" id="productdetails" name="productdetails" value="${product.productdetails}"/></td>
	</tr>
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update Product"/></td>
		</center>
	</tr>
</table>
</form>
</body>
</html>