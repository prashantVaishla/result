<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="container">
		<div class="profile">
			<button class="profile__avatar" id="toggleProfile">
				<!--Image path of the user in src below-->
				<img src="images/logo.jpg" alt="Avatar" />
			</button>

			<form:form method="POST" action="${pageContext.servletContext.contextPath}/authenticate"
				commandName="command" name="credential">
				<%-- <form method="post" action="/result/authuser" name="credential"> --%>
				<div class="profile__form">
					<div class="profile__fields">
						<div class="field">
						<form:input path="username" name="username" id="username" class="input"/>
							<!-- <input type="text" id="username" name="username" class="input"
								required pattern=.*\S.* />  -->
							<label for="username" class="label">Username</label>
						</div>
						<div class="field">
							<form:input type="password" path="pwd" name="pwd" id="pwd" class="input"/>
							<!-- <input type="password" id="pwd" name="pwd" class="input" required
								pattern=.*\S.* />  -->
							<label for="pwd" class="label">Password</label>
						</div>
						<div class="profile__footer">
							<form:button>Login</form:button>
							<!-- <input id="btnSubmit" type="submit" value="login"> <a
								href="empformNew">new</a> -->
						</div>
					</div>
				</div>
				<%-- </form> --%>
			</form:form>
		</div>
	</div>
	<div>${message}</div>
	<div>${pageContext.servletContext.contextPath}</div>
	<script src="js/index.js"></script>
	<script src="js/jquery.js"></script>



</body>
</html>
