<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/main.css" type="text/css" media="screen">
<link href="css/prettyPhoto.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="css/jquery-ui-1.10.1.custom.css" type="text/css" media="screen">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<title>Account</title>
</head>
<body>

   <fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
   <fmt:setBundle basename="resources.locale" var="loc" /><!-- locale_ru  -->
   
   <fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
   <fmt:message bundle="${loc}" key="locale.change_language.en" var="en" />
    <fmt:message bundle="${loc}" key="locale.index.login_form" var="login_form" />
    <fmt:message bundle="${loc}" key="locale.index.book_room" var="book_room" />
     <fmt:message bundle="${loc}" key="locale.index.give_feedback" var="give_feedback" />
    <fmt:message bundle="${loc}" key="locale.index.show_free_rooms" var="show_free_rooms" />
    <fmt:message bundle="${loc}" key="locale.index.search_for_room" var="search_for_room" />
     <fmt:message bundle="${loc}" key="locale.index.log_out" var="log_out" />
     <fmt:message bundle="${loc}" key="locale.index.go_to_main" var="go_to_main" />
   
   <br/> 
   <div class="menu">
   <div id="logo" class="fleft">
			<a href="javascript:void(0);"><img src="images/logo.png" /></a>
		</div>	
	<form action="Controller" method="post">
		<input type="hidden"  name="command" value="logOut" /> 
		 <input type="submit" class="btn btn-danger" name="log out" value="${log_out}" />
		 <input type="hidden"  name="command" value="GO_TO_MAIN" /> 
		 <input type="submit" class="btn btn-success" name="go to main" value="${go_to_main}" />
	</form>
	</div>
	
	
	<div class="slide" id="slide1" data-slide="1" data-stellar-background-ratio="0.5">
	<br/>
	<br/>
	<br/>
	<h3>${login_form}!</h3>
	
	<!--<form action="Controller" method="post">
		<input type="hidden"  name="command" value="search_for_room" /> 
		 <input type="submit" class="btn btn-primary" name="search for room" value="${search_for_room}"/>
	</form>-->
	<br/>
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="show_free_rooms" /> 
		 <input type="submit"class="btn btn-success" name="sing in" value="${show_free_rooms}" />
	</form>
	<br/>
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="book_room_form" /> 
		 <input type="submit" class="btn btn-info"name="sing in" value="${book_room}" />
	</form>
	<br/>
	
<form action="Controller" method="post">
		<input type="hidden" name="command" value="give_feedback_form" /> 
		 <input type="submit" class="btn btn-danger" name="sing in" value="${give_feedback}" />
	</form>
		
	<br/>
</div>
	
</body>
</html>