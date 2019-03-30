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

<h3 align="center">Update Supplier Page</h3>

<form action="<c:url value="/updateSupplier"/>" method="post">

<table align="center">
	<tr>
		<td>Supplier ID </td>
		<td><input type="text" id="supplierId" name="supplierId" value="${supplier.supplierId}" readonly/></td>
	</tr>
	<tr>
		<td>Supplier name </td>
		<td><input type="text" id="supplierName" name="supplierName" value="${supplier.supplierName}"/></td>
	</tr>
	<tr>
		<td>Supplier Address </td>
		<td><input type="text" id="supplierAddress" name="supplierAddress" value="${supplier.supplierAddress}"/></td>
	</tr>
	<tr>
		<td>Supplier Contact </td>
		<td><input type="text" id="supplierContact" name="supplierContact" value="${supplier.supplierContact}"/></td>
	</tr>
	<tr>
		<td>Supplier Email </td>
		<td><input type="text" id="supplierGmail" name="supplierGmail" value="${supplier.supplierGmail}"/></td>
	</tr>
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update Supplier"/></td>
		</center>
	</tr>
</table>
</form>
</body>
</html>