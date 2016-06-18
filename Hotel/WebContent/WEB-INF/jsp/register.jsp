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
   
   <fmt:message bundle="${loc}" key="locale.index.show_news" var="show_news" />
   <fmt:message bundle="${loc}" key="locale.index.show_free_rooms" var="show_free_rooms" />
   <fmt:message bundle="${loc}" key="locale.index.give_feedback" var="give_feedback" />
   <fmt:message bundle="${loc}" key="locale.index.registerTitle" var="registerTitle" />
   <fmt:message bundle="${loc}" key="locale.index.authorization" var="authorization" />

     
     
 
	
<h2 align="center">${registerTitle}!</h2>

	<form action="Controller" method="post">
		<input type="hidden" name="command" value="logination" /> 
		 <input type="submit" name="sign in" value="${authorization}" />
	</form>
	<br/>
	
	
	<br/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_news" /> 
		 <input type="submit" name="sign in" value="${show_news}" />
	</form>
	<br/>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_free_rooms" /> 
		 <input type="submit" name="show free rooms" value="${show_free_rooms}" />
	</form>
<br/>
	
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="give_feedback" /> 
		 <input type="submit" name="sing in" value="${give_feedback}" />
	</form>
	<br/>
</body>
</html>