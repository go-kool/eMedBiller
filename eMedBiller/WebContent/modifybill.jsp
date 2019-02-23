<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modify Bill</title>
</head>
<body>
	<form name="billForm" action="modifybill" method="POST">
		<a href="home.jsp"><button type="button">Home</button></a> <a
			href="logout" style="float: right"><button type="button">logout</button></a>
		<h1>Modify Bill</h1>
		<c:out value="${error}" />
		<c:out value="${success}" />
		<table>
			<tr>

				<td>Patient Name</td>
				<td><input type="text" name="patientName" required><br /></td>

			</tr>
			<tr>
				<td>Doctor Name</td>
				<td><input type="text" name="doctorName" required /><br /></td>
			</tr>
			<tr>
				<td>Date of Transaction</td>
				<td><input type="date" name="transactionTime"
					value="${current}" required> <br /></td>
			</tr>
			<tr>
				<td>Medicine</td>
				<td><select multiple="multiple">
						<option>Select a Medicine</option>
						<c:forEach items="${medicine}" var="medicine">
							<option>${medicine.name}</option>
						</c:forEach>
				</select><br /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="units" id="units" value="1"
					required></td>

			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" id="price" required
					onfocus="calc()"></td>
			</tr>


		</table>
		<input type="submit" value="Modify Bill">
	</form>
</body>
</html>