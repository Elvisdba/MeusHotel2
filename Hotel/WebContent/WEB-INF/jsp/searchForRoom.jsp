<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search</title>
</head>
<body>
Search For Room
    <fmt:message bundle="${loc}" key="locale.index.search_for_room" var="search_for_room" />
<p/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="search_for_room" /> 
		Type: <input type="text" name="type" value="" /><br />
		Price a day: <input type="text" name="price_a_day" value="" /> <br />
		Kind: <input type="text" name="type" value="" /><br />
		
	</form>
</body>
</html>