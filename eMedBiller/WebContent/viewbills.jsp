<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bills</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body class="bg">
<a href="home.jsp"><button type="button" >Home</button></a>

<a href="logout" style="float:right"><button type="button" >logout</button></a>

<table>
		<tr>
			<th>Date</th>
			<th>Patient Name</th>
			<th>Doctor Name</th>
			<th>Bill Amount</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${bills}" var="bill">
			<tr>
				<td>${bill.patientName}</td>
				<td>${bill.doctorName}</td>
				<td>${bill.date}</td>
				<td>${bill.price}</td>
				<td><a href="showbill?id=${bill.id}">Edit</a></td>

			</tr>
		</c:forEach>

	</table>
	
	</body>
</html>