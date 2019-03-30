<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
  display: none;
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
<h2>Admin Console</h2>
<h2>Welcome : <security:authentication property="principal.username"></security:authentication></h2>
<h6><a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></h6>
<%-- <c:url var="logoutUrl" value="/j_spring_security_logout" />
    <form action="${logoutUrl}" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}"
            value="${_csrf.token}" />
    </form>
    <a href="#" onclick="document.getElementById('logout').submit();">Logout</a> --%>
<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Category')">Categories</button>
  <button class="tablinks" onclick="openCity(event, 'Product')">Product</button>
  <button class="tablinks" onclick="openCity(event, 'Users')">Users</button>
   <button class="tablinks" onclick="openCity(event, 'Supplier')">Supplier</button>
</div>

<div id="Category" class="tabcontent">
  <embed src="/Ecommfrontend/category" style="width:900px; height: 800px;">
</div>

<div id="Product" class="tabcontent">
  <embed src="/Ecommfrontend/product" style="width:900px; height: 800px;">
</div>

<div id="Users" class="tabcontent">
  <embed src="/Ecommfrontend/user" style="width:900px; height: 800px;">
</div>

<div id="Supplier" class="tabcontent">
 <embed src="/Ecommfrontend/supplier" style="width:900px; height: 800px;">
</div>
<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
   
</body>
</html> 
