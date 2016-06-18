<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/book.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>Give feedback</title>
</head>
<body>
	<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->


	<fmt:message bundle="${loc}" key="locale.index.nameForm" var="nameForm" />
	<fmt:message bundle="${loc}" key="locale.index.emailForm"
		var="emailForm" />
	<fmt:message bundle="${loc}" key="locale.index.msgForm" var="msgForm" />
	<fmt:message bundle="${loc}" key="locale.index.titleForm"
		var="titleForm" />
	<fmt:message bundle="${loc}" key="locale.index.send" var="send" />
<fmt:message bundle="${loc}" key="locale.index.go_to_main" var="go_to_main" />
<form action="Controller" method="post">
<div id="logo" class="fleft" align="left">
			<a href="javascript:void(0);"><img src="images/logo.png" /></a>
			 <input type="hidden"  name="command" value="GO_TO_MAIN" /> 
		 <input type="submit" class="btn btn-success" name="go to main" value="${go_to_main}" />
		</div>
	 
	</form>

<form action="Controller" method="post">
<input type="hidden" name="command" value="give_feedback" /> 

  <div class="form-group" align="left">
    <label for="name">${nameForm}:</label>
    <input type="text" name="name" class="form-control"  placeholder="${nameForm}">
    <br/>
    <label for="email">${emailForm}:</label>
    <input type="email" name="email" class="form-control"  placeholder="${emailForm}">
    <br/>
    <p>
            <textarea rows="4" cols="50" name="message" placeholder="${msgForm}:"
			class="message"></textarea>
        </p>
        <input type="submit" class="btn btn-info" value="${send}"/>
        </div>
        </form>

</body>
</html>