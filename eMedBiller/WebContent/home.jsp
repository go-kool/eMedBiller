<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body class="bg">
	<div>
		<marquee>
			<h3>Page under Construction!</h3>
		</marquee>
		<a href="logout" style="float: right"><button type="button">logout</button></a>
		<center>
			<form action="searchmedicine" method="post">
				Enter Medicine Name <input type="text" name="search" required>
				<input type="submit" value="Search">
			</form>
			<c:out value="${error}" />
			
			<br /> <a href="billgenerator">Generate a New Bill</a> <br /> <a
				href="viewbills">View Bills</a> <br /> <a href="viewmedicines">View
				Medicines</a> <br /> <a href="addmedicine.jsp">Add Medicine</a>
				
				
				<form action="searchbills" method="post">
				<h4>--Fetch bills between dates--</h4>
				From Date:<input type="date" name="fromdate"><br/>
				  To Date:<input type="date" name="todate"><br/>
				<input type="submit" value="Fetch">
				</form>
		</center>
	</div>
	<div class="split">
		<table class="th">
			<tr>

				<th>Patient Name &nbsp&nbsp</th>
				<th>Doctor Name &nbsp&nbsp</th>
				<th>Date &nbsp&nbsp&nbsp</th>
				<th>Bill Amount &nbsp&nbsp</th>
				<th>Action &nbsp&nbsp</th>
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
	</div>



</body>
</html>