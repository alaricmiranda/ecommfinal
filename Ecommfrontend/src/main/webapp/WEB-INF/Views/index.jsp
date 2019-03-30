<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<style>
* {box-sizing: border-box;}
body {font-family: Verdana, sans-serif;}
.mySlides {display: none;}
img {vertical-align: middle;}

.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

 .ul{
  list-style-type: none;
  margin: 3px;
  padding: 70px;
  text-align: center;
  overflow: hidden;
  float: left;
 }
 .ul li a {
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
.ul li img {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 150px;
}

.text {
  color: #f2f2f2;
  font-size: 15px;
  padding: 8px 12px;
  position: absolute;
  bottom: 8px;
  width: 100%;
  text-align: center;
}


.numbertext {
  color: #f2f2f2;
  font-size: 12px;
  padding: 8px 12px;
  position: absolute;
  top: 0;
}


.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.active {
  background-color: #717171;
}


.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}


h3
{
display: block;
  color:  white;
  text-align: center;
  padding: 4px 7px;
  text-decoration: none;
  background-color: #333;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="slideshow-container">	
<%-- <h6><a href="<c:url value='j_spring_security_logout'/>">Click here to logout</a></h6>
 --%><div class="mySlides fade">
  <div class="numbertext">1 / 3</div>
  <img src="resources/slide1.jpg" style="width:100%">
  <div class="text"></div>
</div>

<div class="mySlides fade">
  <div class="numbertext">2 / 3</div>
  <img src="resources/slide2.jpg" style="width:100%">
  <div class="text"></div>
</div>
</div>
<br>

<div style="text-align:center">
  <span class="dot"></span> 
  <span class="dot"></span> 
</div>
<h3>Products</h3>
<div class="display">
	<c:forEach items="${listProducts}" var="product">
	<ul class="ul">
		<li><img src="resources/50x50.png"></li>
		<li>${product.productname}</li>
		<li>${product.productdetails}</li>
		<li>${product.price}.Rs</li>
		
		<li>
		<sec:authorize access="!isAuthenticated()">
  	<a href="/Ecommfrontend/log" style="color:red;">Login to Add to Cart</a>
   </sec:authorize>
  <sec:authorize access="isAuthenticated()">
  <a href="<c:url value="/addtocart-${product.productid}"/>">Add To Cart</a>
</sec:authorize>
		</li>
	</ul>
	</c:forEach>
	

</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000);
}
</script>
</body>
</html>
