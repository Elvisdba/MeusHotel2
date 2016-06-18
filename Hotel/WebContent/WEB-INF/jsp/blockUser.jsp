<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="css/book.css">
<title>Account</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" /><!-- locale = ru -->
   <fmt:setBundle basename="resources.locale" var="loc" /><!-- locale_ru  -->
        <fmt:message bundle="${loc}" key="locale.index.log_out" var="log_out" />
     <fmt:message bundle="${loc}" key="locale.index.go_to_main" var="go_to_main" />
     <fmt:message bundle="${loc}" key="locale.index.block_user" var="block_user" />
     
   <div class="menu" align="left">
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
	
   <form action="Controller" method="post">
		<input type="hidden" name="command" value="block_user" />
		<div class="form-group">
			<h2 class="heading">${block_user}</h2>
			<div class="grid"> 
   <div class="col-1-4 col-1-4-sm">
					<div class="controls">
						<input type="text" class="floatLabel"
							name="login_block" value="" /> <label for="login_block" class="label-date">Логин пользователя</label>
					</div>
				</div>
				</div>
				<button type="submit" value="Submit" class="col-1-4">${block_user}</button>
				</div>
				<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery-ui-autocomplete.js'></script>
	<script
		src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery.select-to-autocomplete.js'></script>
	<script
		src='http://raw.githubusercontent.com/andiio/selectToAutocomplete/master/jquery.select-to-autocomplete.min.js'></script>

	<script src="js/booking.js"></script>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
				</form>
</body>
</html>