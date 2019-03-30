<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<style>
.lih {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

.lih li {
  float: left;
  border-right:1px solid #666666;
  border-left:1px solid #666666;
}
.lih li:first-child {
 border-right: none;
}

.lih li:last-child {
  border-right: none;
   border-left:none;
}

.lih li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.lih li a:hover{
  background-color: #111;
}


input
{
 width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
label
{
font-weight: bold;
text-align: justify;
}
form
{
border: 3px solid white;
}
.modallog {
  display: none; 
  position: fixed; 
  z-index: 1; 
  padding-top: 100px; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
}
.modal-content {
  position: relative;
  background-color: #fefefe;
  margin: auto;
  padding: 0;
  border: 1px solid #888;
  width: 30%;
  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19);

}
.modalreg {
  display: none; 
  position: fixed; 
  z-index: 1; 
  padding-top: 100px; 
  left: 0;
  top: 0;
  width: 100%; 
  height: 100%; 
  overflow: auto; 
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0,0.4); 
}

.close {
  color: white;
  float: right;
  font-size: 28px;
  font-weight: bold;
}
.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
  }
.modal-header {
  padding: 2px 16px;
  background-color: #333;
  color: white;}
  
 .modal-body {padding: 2px 16px;}

.modal-footer {
  padding: 2px 16px;
  background-color: #333;
  color: white;
}
.Regb {
width: auto;
display: block;
color: white;
text-align: center;
text-decoration: none;
border: 2px white;	
padding: 10px 18px;
background-color: #333;
color:white;
float:center;
}
.bbutton{
display: block;
  color: #1ABC9C;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  background-color: #333;
  border: 2px  black;
}
.okbutton
{
width: auto;
display: block;
color: white;
text-align: center;
text-decoration: none;
border: 2px white;
padding: 10px 18px;
background-color: #333;
color:white;
}
.h2
{
display: block;
  color:  white;
  text-align: center;
  padding: 0px 7px;
  text-decoration: none;
  background-color: #333;
}
  </style>
</head>
<body>

<h3 align="center">Category Page</h3>

<form action="<c:url value="/addCategory"/>" method="post">

<table align="center">
	<tr>
		<td>Category Name </td>
		<td><input type="text" id="categoryName" name="categoryName"/></td>
	</tr>
	<tr>
		<td>Category Desc </td>
		<td><input type="text" id="categoryDesc" name="categoryDesc"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Add Category"/></td>
	</tr>
</table>
</form>

<table align="center" border="1">
	<tr>
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operations</td>
	</tr>
	<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="<c:url value="/editCategory/${category.categoryId}"/>">Edit</a>
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>