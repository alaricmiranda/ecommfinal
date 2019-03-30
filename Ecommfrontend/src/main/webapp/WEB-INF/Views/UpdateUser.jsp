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

<h3 align="center">Update User Page</h3>

<form action="<c:url value="/updateUser"/>" method="post">

<table align="center">
	<tr>
		<td>User ID </td>
		<td><input type="text" id="userId" name="userId" value="${user.userId}" readonly/></td>
	</tr>
	<tr>
		<td>User Name </td>
		<td><input type="text" id="userName" name="userName" value="${user.userName}"/></td>
	</tr>
	<tr>
		<td>User Email </td>
		<td><input type="text" id="userEmailId" name="userEmailId" value="${user.userEmailId}"/></td>
	</tr>
	<tr>
		<td>User Contact </td>
		<td><input type="text" id="userContact" name="userContact" value="${user.userContact}"/></td>
	</tr>
	<tr>
		<td>User Password </td>
		<td><input type="text" id="userPassword" name="userPassword" value="${user.userPassword}"/></td>
	</tr>
	<tr>
		<td>User role </td>
		<td><input type="text" id="userRole" name="userRole" value="${user.userRole}"/></td>
	</tr>
	<tr>
		<center>
		<td colspan="2"><input type="submit" value="Update User"/></td>
		</center>
	</tr>
</table>
</form>
</body>
</html>