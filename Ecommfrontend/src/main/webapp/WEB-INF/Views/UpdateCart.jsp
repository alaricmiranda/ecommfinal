<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="/updateCart"/>" method="post">

<table align="center">
	<tr>
		<td><input type="hidden" id="cartId" name="cartId" value="${cart.cartId}" readonly/></td>
	</tr>
	<tr>
		<td>Product Name </td>
		<td><input type="text" id="productname" name="productname" value="${cart.productname}"readonly/></td>
	</tr>
	
	<tr>
		<td>Product Quantity </td>
		<td><input type="number" id="quantity" name="quantity" value="${cart.quantity}"/></td>
	</tr>
	
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update Cart"/></td>
		</center>
	</tr>
</table>
</form>
</body>
</html>