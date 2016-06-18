<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
   <fmt:setBundle basename="resources.locale" var="loc" /><!-- locale_ru  -->
   
   <fmt:message bundle="${loc}" key="locale.index.pay" var="pay" />
   <fmt:message bundle="${loc}" key="locale.index.card_number" var="card_number" />
<fmt:message bundle="${loc}" key="locale.index.name_on_card" var="name_on_card" />
<fmt:message bundle="${loc}" key="locale.index.expiration" var="expiration" />

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="payment" /> 
		${card_number}: <input type="text" name="cardNum" value="" />CVV:<input type="text" name="type" value="" /><br />
		${name_on_card}: <input type="text" name="name" value="" />${expiration}:<input type="text" name="type" value="" /> <br /> 
		<input type="submit" name="pay" value="${pay}" />
	</form>
</body>
</html>