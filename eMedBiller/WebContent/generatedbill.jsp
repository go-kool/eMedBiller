<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order #${orderId}</title>
</head>
<body>
	<center>
		<h1>Bill Invoice</h1>
		<table>
			<tr>
				<td>Patient Name: ${order.patientName}</td>
			</tr>
			<tr>
				<td>Doctor Name: ${order.doctorName}</td>
			</tr>
			<tr>
				<td>Transaction Date: ${order.date}</td>
			</tr>
			<tr>
				<td>Billed By: ${order.user.userName}</td>
			</tr>
			<c:forEach items="${medicines}" var="medicine">
				<tr>
					<td>Medicine Name: ${medicine}</td>

				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>