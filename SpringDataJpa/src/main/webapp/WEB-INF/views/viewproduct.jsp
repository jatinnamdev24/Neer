<%@ page import="com.tr.model.Product" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><br><br><br>
<a href="productform">Add New Product</a><br>
<form action="search">
Search by Category:<input type="text" name="category">
<input type="submit" value="Search">
</form>
<table border="1" align="center">
<c:forEach var="c" items="${clist}">
<tr>
<td>${c.pid}</td>
<td><a href="">${c.pname}</a></td>
<td>${c.decription}</td>
<td>${c.category}</td>
<td>${c.price}</td>
</tr>
</c:forEach>
</table>
<form action="searchbyrange">
<h3>Search by Range:</h3>
Min:<input type="text" name="min">
Max:<input type="text" name="max">
<input type="submit" value="RangeSearch">
</form>
<table border="1" align="center">

<c:forEach var="r" items="${rlist}">
<tr>
<td>${r.pid}</td>
<td><a href="">${r.pname}</a></td>
<td>${r.decription}</td>
<td>${r.category}</td>
<td>${r.price}</td>
</tr>
</c:forEach>
</table>
<h1 align="center">Shopping Page</h1>
<table border="1" align="center">
<c:forEach var="p" items="${plist}">
<tr>
<td>${p.pid}</td>
<td><a href="">${p.pname}</a></td>
<td>${p.decription}</td>
<td>${p.category}</td>
<td>${p.price}</td>
<td><a href="updateform?pid=${p.pid}">Update</a></td>
<td><a href="delete?pid=${p.pid}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>