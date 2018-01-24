<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/style.css">
<link rel='stylesheet' href='css/googleapi.css' type='text/css'>
</head>

<body>
	<div>${welcomeMessage}</div>

	<h2>${orderConfirmation.total}</h2>
	<form:form method="POST"
		action="confirmOrder"
		modelAttribute="orderConfirmation">
		<table>
			<thead>
				<tr>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach
					items="${orderConfirmation.personListContainer.productList}"
					var="Person" varStatus="i" begin="0">
					<tr class="person">
						<td>${Person.productName}</td><form:hidden path="personListContainer.productList[${i.index}].productName"/>
						<td>${Person.productId}</td><form:hidden path="personListContainer.productList[${i.index}].productId"/>
						<td>${Person.quantity}</td><form:hidden path="personListContainer.productList[${i.index}].quantity"/>
						<td>${Person.price}</td><form:hidden path="personListContainer.productList[${i.index}].price"/>
						<br><form:hidden path="total"/>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<form:button>confirm Order</form:button>
			<!-- <input id="btnSubmit" type="submit" value="login"> <a
								href="empformNew">new</a> -->
		</div>
		<div>${message}</div>
	</form:form>
	<%
		out.println(request.getParameter("message"));
	%>
	<div>${message}</div>
	<script src="js/index.js"></script>
	<script src="js/jquery.js"></script>



</body>
</html>
