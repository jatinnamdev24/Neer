<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Page</title>
</head>
<body><br><br>
<f:form action="update" modelAttribute="product">
<f:hidden path="pid"/>
Product Name<f:input path="pname"/>
<span style="color:red"><f:errors path="pname"></f:errors></span><br><br>
Description<f:input path="decription"/>
<span style="color:red"><f:errors path="decription"></f:errors></span>
<br><br>
Category<f:input path="category"/>
<span style="color:red"><f:errors path="category"></f:errors></span>
<br><br>
Price<f:input path="price"/>
<span style="color:red"><f:errors path="price"></f:errors></span><br><br>
<input type="submit" value="Update">
</f:form>

</body>
</html>