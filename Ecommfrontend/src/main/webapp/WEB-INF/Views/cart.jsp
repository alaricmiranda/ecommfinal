<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<style>
th
    {
	width:3%;
      border-collapse:separate;
      }
.bold
{
font-weight: bold;
}
h3
{
display: block;
  color:  white;
  text-align: center;
  padding: 10px 7px;
  text-decoration: none;
  background-color: #333;
}</style>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h3>Your Cart <sec:authentication property="principal.username"></sec:authentication></h3>
<table>
      <tr>
        <th>
        <th>Name</th>
        <th style="text-align:right"> Amount</th>
        <th style="text-align:right"> Price</th>
        <th style="text-align:right"> Edit</th>
        </tr>
        <c:forEach items="${listCart}" var="cart">
      <tr class="item-row">
        <td>
          <img src="resources/50x50.png"></td>
        <td>
          <p class="bold">${cart.productname}</p>
          <p>${cart.productdetails}</p></td>
        <td style="text-align:right">${cart.quantity} </td>
         <td style="text-align:right">${cart.price}.Rs</td>
         <td style="text-align:right"> <a href="<c:url value="/editCart/${cart.cartId}"/>"><img src="resources/edit.png" alt="HT" style="width:20px;height:20px;border:0;"></a>
			<a href="<c:url value="/deleteCart-${cart.cartId}"/>"><img src="resources/del.png" alt="HT" style="width:20px;height:20px;border:0;"></a></td>
         </tr>
         	</c:forEach>
      <tr style="total-row">
        <td colspan="4" style="text-align:right"> Total</td>
        <td style="text-align:right"><c:out value="${total}" /></td>
        </tr>
        </table>
        <h3> </h3>
</body>
</html>