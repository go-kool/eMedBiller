<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to eMedBiller</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body class="bg">
	<center>
		<h1>Login</h1>
		<c:out value="${error}" />
		<form action="authenticate" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username" value="${userName}" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required></td>
				</tr>
			</table>
			<input type="submit" value="Login">
		</form>
	</center>
</body>
</html>