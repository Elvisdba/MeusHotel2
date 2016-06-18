<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Imperial</title>
</head>
<body>

	<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
	<fmt:message bundle="${loc}" key="locale.index.login" var="login" />
	<fmt:message bundle="${loc}" key="locale.index.log_out" var="log_out" />
	<fmt:message bundle="${loc}" key="locale.index.login_title" var="login_title" />
	<fmt:message bundle="${loc}" key="locale.index.register_title" var="register_title" />
	<fmt:message bundle="${loc}" key="locale.index.password" var="password" />
	<fmt:message bundle="${loc}" key="locale.index.repeat_pass" var="repeat_pass" />
	<fmt:message bundle="${loc}" key="locale.index.sign_in" var="sign_in" />
	<fmt:message bundle="${loc}" key="locale.index.next" var="next" />
	<fmt:message bundle="${loc}" key="locale.index.name" var="name" />
    <fmt:message bundle="${loc}" key="locale.index.surname" var="surname" />
    <fmt:message bundle="${loc}" key="locale.index.forgot_pass" var="forgot_pass" />
      <fmt:message bundle="${loc}" key="locale.index.log_out" var="log_out" />


	<jsp:useBean id="errorMessage" class="java.lang.String" scope="request" />



	<div class="container">
		<div class="card"></div>
		<div class="card">
			<div class="input-container">

				<h1 class="title">${login_title}</h1>

							
				<form action="Controller" method="post">
					<div class="input-container">
						<font size="5" face="cursive"> 
						<input type="hidden"
							name="command" value="logination" /> ${login}: <br /> 
							<input type="text" name="login" value="" /><br />${password}:</font><br />
							<input type="password" name="password" value="" />
							

						<i> <font color="red"> <c:if
									test="${errorMessage!=null}">
									<c:out value="${errorMessage}" />
								</c:if>
						</font></i>
					</div>
				
					<div class="button-container">
						<button>
							<span>${sign_in}</span>
						</button>
					</div>


					<div class="footer">
						<a href="#">${forgot_pass}?</a>
					</div>
				</form>
			</div>
		</div>


		<div class="card alt">
			<div class="toggle"></div>
			<h1 class="title">${register_title}
				<div class="close"></div>
			</h1>
			
			<form action="Controller" method="post">
                 <div class="input-container">
					<input type="text" name="name" /> <label
						for="name">${name}</label>
					<div class="bar"></div>
				</div>
				 <div class="input-container">
					<input type="text" name="surname" /> <label
						for="surname">${surname}</label>
					<div class="bar"></div>
				</div>

			
				<div class="input-container">
					<input type="hidden" name="command" value="registration" /> 
					<input type="text" name="login" value="" /> <label for="login">${login}</label>
					<div class="bar"></div>
				</div>


				<div class="input-container">
					<input type="password" name="password" /> <label for="password">${password}</label>
					<div class="bar"></div>
				</div>
				<div class="input-container">
					<input type="password" name="repeat_pass" /> <label
						for="repeat_pass">${repeat_pass}</label>
					<div class="bar"></div>
				</div>
				
				<div class="button-container">
					<button>
						<span>${next}</span>
					</button>
				</div>
			</form>
		</div>
	</div>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>


</body>
</html>