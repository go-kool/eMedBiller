<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Medicines</title>
</head>
<body>
	<center>
		<form method="post" name="selectMedicinesForm" action="setquantity">
			<input type="hidden" name="bill" value="${bill}">
			<c:forEach items="${medicines}" var="medicine">

				<input type="checkbox" name="selectedMed" value="${medicine.id}"> ${medicine.name}
				</c:forEach>
			<br/><input type="submit" value="Continue">
		</form>
	</center>
</body>
</html>