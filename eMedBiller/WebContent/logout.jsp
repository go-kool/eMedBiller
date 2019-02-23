<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank you!</title>
<script type="text/javascript">
	function Redirect() {
		window.location = "login.jsp";
	}
	document.write("You will be redirected to a login page in 3 seconds");
	setTimeout('Redirect()', 3000);
</script>
</head>
<body>
	<center>
		<h1>You have successfully logged out!</h1>
		<h2>
			Thank you for using <b>eMedBiller</b>!
		</h2>
	</center>
</body>
</html>