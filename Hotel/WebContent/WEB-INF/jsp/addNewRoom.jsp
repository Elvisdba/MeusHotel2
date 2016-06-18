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
<link rel="stylesheet" href="css/book.css">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}" />
	<!-- locale = ru -->
	<fmt:setBundle basename="resources.locale" var="loc" />
	<!-- locale_ru  -->
<fmt:message bundle="${loc}" key="locale.index.room_type"
		var="room_type" />
	<fmt:message bundle="${loc}" key="locale.index.room_kind"
		var="room_kind" />
		<fmt:message bundle="${loc}" key="locale.index.isValid"
		var="isValid" />
		<fmt:message bundle="${loc}" key="locale.index.add"
		var="add" />
		
		
		<div id="logo" class="fleft" align="left">
			<a href="javascript:void(0);"><img src="images/logo.png" /></a>
		</div>	
       <form action="Controller" method="post">
		<input type="hidden" name="command" value="add_new_room" /> 
		<div class="form-group">
			<h2 class="heading">Add new room</h2>
			<div class="grid">
				
				
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
                      <div class="col-1-3 col-1-3-sm">
					<div class="controls">
						<select class="floatLabel" name="isValid">
							<option value="blank"></option>
							<option value="OK">OK</option>
							<option value="RES">RES</option>
							
						</select> <label for="fruit">${isValid}</label>
					</div>
				</div>
				
				<div class="col-1-4 col-1-4-sm">
					<div class="controls">
						<input type="text" class="floatLabel"
							name="price_a_day" value="" /> <label for="price_a_day" class="label-date">Цена в день</label>
					</div>
				</div>
				<br/>
				<br/>
				
			</div>
			<button type="submit" value="Submit" class="col-1-4">${add}</button>
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