<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book your room</title>
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<link href='http://fonts.googleapis.com/css?family=Lato:300,400'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="css/book.css">
</head>

<body>
	<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->

	<fmt:message bundle="${loc}" key="locale.index.pay" var="pay" />
	<fmt:message bundle="${loc}" key="locale.index.book" var="book" />
	<fmt:message bundle="${loc}" key="locale.index.people" var="people" />
	<fmt:message bundle="${loc}" key="locale.index.room_type"
		var="room_type" />
	<fmt:message bundle="${loc}" key="locale.index.room_kind"
		var="room_kind" />
	<fmt:message bundle="${loc}" key="locale.index.wish" var="wish" />
	<fmt:message bundle="${loc}" key="locale.index.comments" var="comments" />
	<fmt:message bundle="${loc}" key="locale.index.go_to_main"
		var="go_to_main" />
	<fmt:message bundle="${loc}" key="locale.index.send" var="send" />
	

	<div id="logo" class="fleft" align="left">
			<a href="javascript:void(0);"><img src="images/logo.png" /></a>
		</div>	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="GO_TO_MAIN" /> 
		<button type="submit" value="${go_to_main}" class="col-1-4">${go_to_main}</button>
	</form>
	
	
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="book_room" />
		<div class="form-group">
			<h2 class="heading">${book}</h2>
			<div class="grid">
				<div class="col-1-4 col-1-4-sm">
					<div class="controls">
						<input type="text" id="datepicker" class="floatLabel"
							name="arrive" value="" /> <label for="arrive" class="label-date"><i
							class="fa fa-calendar"></i>&nbsp;&nbsp;Въезд</label>

					</div>
				</div>
				<div class="col-1-4 col-1-4-sm">
					<div class="controls">
						<input type="text" id="datepicker1" class="floatLabel"
							name="depart" value="" /> <label for="depart" class="label-date"><i
							class="fa fa-calendar"></i>&nbsp;&nbsp;Отъезд</label>
					</div>
				</div>
			</div>
			<div class="grid">
				<div class="col-1-3 col-1-3-sm">
					<div class="controls">
						<select class="floatLabel" name="people">
							<option value="blank"></option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select> <label for="people"><i class="fa fa-male"></i>&nbsp;&nbsp;${people}</label>
					</div>
				</div>
				
				
				<div class="col-1-3 col-1-3-sm">
					<div class="controls">
						<select class="floatLabel" name="kind">
							<option value="blank"></option>
							<option value="3 stars">3 stars</option>
							<option value="4 stars">4 stars</option>
							<option value="5 stars">5 stars</option>
						</select> <label for="fruit">${room_kind}</label>
					</div>
				</div>

				<div class="col-1-3 col-1-3-sm">
					<div class="controls">
						<select class="floatLabel" name="type">
							<option value="blank"></option>
							<option value="1 BDRM">1 BDRM</option>
							<option value="2 BDRM">2 BDRM</option>
							<option value="Apartment">Apartment</option>
							<option value="DeLuxe">DeLuxe</option>
							<option value="Duplex">Duplex</option>
							<option value="King suite">King suite</option>
							<option value="President">President</option>
							<option value="Family room">Family room</option>
						</select> <label for="fruit">${room_type}</label>
					</div>
				</div>

			</div>
			<div class="grid">
				<h2 class="heading">${wish}</h2>
				<div class="controls">
					<textarea rows="4" cols="50" name="message"
						placeholder="${msgForm}:"></textarea>
					
				</div>
				<button type="submit" value="Submit" class="col-1-4">${send}</button>
			</div>
		</div>
	</form>
	
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
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
<script>
		$(function() {
			$("#datepicker1").datepicker();
		});
	</script>
</body>
</html>


