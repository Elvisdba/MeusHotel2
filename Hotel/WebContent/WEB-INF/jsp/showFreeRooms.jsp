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
<title>Insert title here</title>
</head>
<body>

	<fmt:setLocale value="${sessionScope.locale}" />
	<fmt:setBundle basename="resources.locale" var="loc" />
    <fmt:message bundle="${loc}" key="locale.index.room_kind" var="room_kind" />
	<fmt:message bundle="${loc}" key="locale.index.room_type" var="room_type" />
	<fmt:message bundle="${loc}" key="locale.index.price_a_day" var="price_a_day" />

	<br />
	<table class="table table-condensed">
	<tr>
			<td>${room_kind}:</td>
			<td>${room_type}:</td>
			<td>${price_a_day}:</td>
		</tr>
		<c:forEach var="room" items="${requestScope.free_rooms}">
			<tr>
			    <td><c:out value="${room.kind}" /></td>
				<td><c:out value="${room.type}" /></td>
				<td><c:out value="${room.price_a_day}" /></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>