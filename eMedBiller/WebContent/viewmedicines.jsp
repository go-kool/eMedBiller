<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Medicine</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body class="bg">
	<a href="home.jsp"><button type="button" >Home</button></a>
	<a href="logout" style="float:right"><button type="button" >logout</button></a>
	<center>
	<br>
	<table border="1">
	
		<tr>
			<th>Medicine Name</th>
			<th>Type</th>
			<th>Items per Strip</th>
			<th>No of Strips</th>
			<th>Cost Price</th>
			<th>Selling Price</th>
			<th>Quantity</th>

		</tr>
		<c:forEach items="${medicines}" var="medicine">
			<tr>
				<td>${medicine.name}</td>
				<td>${medicine.item.type}</td>
				<td>${medicine.itemsPerStrip}</td>
				<td>${medicine.strips }</td>
				<td>${medicine.costPrice}</td>
				<td>${medicine.sellingPrice}</td>
				<td>${medicine.quantity }</td>
				<td><a href="showmedicine?id=${medicine.id}">Edit</a></td>

			</tr>
		</c:forEach>

		</table>
	</center>
</body>
</html>