<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<title>Show Users</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->
	<fmt:message bundle="${loc}" key="locale.index.name" var="name" />
	<fmt:message bundle="${loc}" key="locale.index.surname" var="surname" />
	<table class="table table-condensed">
		<tr>
			<td>${name}:</td>
			<td>${surname}:</td>
		</tr>
		<c:forEach var="user" items="${requestScope.show_users}">
			<tr>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.surname}" /></td>


			</tr>
		</c:forEach>

	</table>

</body>
</html>