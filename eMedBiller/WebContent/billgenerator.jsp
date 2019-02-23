<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">




	function getQuatity() {

		var x = document.getElementById("sel");
		for (var i = 0; i < x.options.length; i++) {
			if (x.options[i].selected == true) {

				var sp = x.options[i].value.split('-');

				var quantity = prompt("Please enter quantity for "
						+ sp[0], "1");

				
				var form = document.getElementById("billGen");

				var table = document.getElementById("table");
				var tr = document.getElementById("medicinedata");

				var td = document.createElement("td");
				var n = document.createTextNode("No. of " + sp[0]); // Create a text node
				td.appendChild(n);

				var td_new = document.createElement("td");
				var tr_new = document.createElement("tr");
				var input = document.createElement("input");
				input.setAttribute("name", "medicineQuantity");
				input.setAttribute("value", quantity);
				input.setAttribute("readonly", "readonly");
				tr_new.appendChild(td);
				td_new.appendChild(input);
				tr_new.append(td_new);

				var td_new1 = document.createElement("td");
				var p = document.createTextNode("Price for "
						+ sp[0]); // Create a text node
				td_new1.appendChild(p);

				var price = document.createElement("input");
				price.setAttribute("name", "price");
				price.setAttribute("value", quantity * sp[1]);
				price.setAttribute("readonly", "readonly");
				
				

				td_new1.appendChild(price);
				
				var medId= document.createElement("input");
				medId.setAttribute("type", "hidden");
				medId.setAttribute("name", "medicineId");
				medId.setAttribute("value", sp[2]);
				
				var medName= document.createElement("input");
				medName.setAttribute("type", "hidden");
				medName.setAttribute("name", "medicineName");
				medName.setAttribute("value", sp[0]);
				tr_new.append(td_new1);

				table.append(tr_new);
				document.getElementById("billGen").appendChild(medId);
				document.getElementById("billGen").appendChild(medName);
			}
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bill Generation</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body class="bg">
	<a href="home.jsp"><button type="button">Home</button></a>
	<a href="logout" style="float: right"><button type="button">logout</button></a>
	<center>
		<h1>Bill Generator</h1>


		<form name="billGeneratorForm" id="billGen" method="POST"
			action="createbill">

			<table id="table">

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
					<td><input type="date" name="date" required> <br /></td>
				</tr>
				<tr>
					<td>Select Medicines</td>
					<td><select name="medicines" id="sel">
							<c:forEach items="${medicines}" var="medicine">
								<option value="${medicine.name}-${medicine.sellingPrice}-${medicine.id}">${medicine.name}</option>
							</c:forEach>
					</select>
						<button type="button" onclick="getQuatity()">Select
							Quantity</button></td>
				</tr>
				<tr id="medicinedata">
				</tr>


			</table>


			<input type="submit" value="Generate">
		</form>

	</center>

</body>
</html>