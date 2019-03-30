<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Us!</title>
<style>
.contact {
  max-width: 100%;
  height: auto;
}
* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 33.33%;
  padding: 5px;
}
.row::after {
  content: "";
  clear: both;
  display: table;
}
.text{
position:relative;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
<img src="resources/contact.jpg" alt="Cinque Terre" width="100%" height="300" class="contact">
<div class="row">
  <div class="column">
    <img src="resources/contactphone.jpg" alt="Snow" style="width:50%">
    <div class="text">
    Phone number-1800 *** ****
    </div>
  </div>
  <div class="column">
    <img src="resources/contactmail.jpg" alt="Forest" style="width:50%">
    <div class="text">
    Email us at-****@***.com
    </div>
  </div>
  <div class="column">
    <img src="resources/contactlocation.jpg" alt="Mountains" style="width:50%">
    <div class="text">
    Visit us at-*********
    </div>
  </div>
</div>
</body>
</html>