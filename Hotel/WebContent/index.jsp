<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale = 1.0, user-scalable = no">
	<title>Imperial</title>
	<link rel="stylesheet" href="css/main.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/jquery-ui-1.10.1.custom.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/normalize.css" type="text/css" media="screen">
	<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
	<link href="css/prettyPhoto.css" rel="stylesheet" type="text/css" />
	
	<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/jquery.prettyPhoto.js"></script>
	<script src="js/jquery-ui-1.10.1.custom.min.js"></script>
	<script src="js/select.js"></script>
	<script type="text/javascript" src="js/js.js"></script>
	<script type="text/javascript" src="js/jquery.stellar.min.js"></script>
	<script type="text/javascript" src="js/waypoints.min.js"></script>
	
	<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<script src="js/respond.src.js"></script>
	<![endif]-->
	
	<script type="text/javascript">
		$(document).ready(function(){	
			$("#ajax-contact-form").submit(function() {
				var str = $(this).serialize();		
				$.ajax({
					type: "POST",
					url: "contact_form/contact_process.php",
					data: str,
					success: function(msg) {
						// Message Sent - Show the 'Thank You' message and hide the form
						if(msg == 'OK') {
							result = '<div class="notification_ok">Your message has been sent. Thank you!</div>';
							$("#fields").hide();
						} else {
							result = msg;
						}
						$('#note').html(result);
					}
				});
				return false;
			});

		});		
	</script>
	
	<script type="text/javascript">$($.date_input.initialize);</script>
	
</head>

<body>

<fmt:setLocale value="${sessionScope.locale}" />
	<fmt:setBundle basename="resources.locale" var="loc" />

	<fmt:message bundle="${loc}" key="locale.change_language.ru" var="ru" />
		<fmt:message bundle="${loc}" key="locale.index.home" var="home" />
	<fmt:message bundle="${loc}" key="locale.index.about" var="about" />
	<fmt:message bundle="${loc}" key="locale.index.contact" var="contact" />
	<fmt:message bundle="${loc}" key="locale.index.dream_title" var="dream_title" />
	<fmt:message bundle="${loc}" key="locale.index.welcome_title" var="welcome_title" />
	<fmt:message bundle="${loc}" key="locale.index.login_title" var="login_title" />
	<fmt:message bundle="${loc}" key="locale.index.register_title" var="register_title" />
	<fmt:message bundle="${loc}" key="locale.index.impressions_title" var="impressions_title" />
	<fmt:message bundle="${loc}" key="locale.index.book" var="book" />
	<fmt:message bundle="${loc}" key="locale.index.type" var="type" />
	<fmt:message bundle="${loc}" key="locale.index.kind" var="kind" />
	<fmt:message bundle="${loc}" key="locale.index.persons" var="persons" />
	<fmt:message bundle="${loc}" key="locale.index.stay_title" var="stay_title" />
	<fmt:message bundle="${loc}" key="locale.index.would_title" var="would_title" />
	<fmt:message bundle="${loc}" key="locale.index.sign_in" var="sign_in" />
	<fmt:message bundle="${loc}" key="locale.index.arrive" var="arrive" />
	<fmt:message bundle="${loc}" key="locale.index.depart" var="depart" />
	<fmt:message bundle="${loc}" key="locale.index.people" var="people" />
		<fmt:message bundle="${loc}" key="locale.index.contact" var="contact" />
	<fmt:message bundle="${loc}" key="locale.index.privacy_policy" var="privacy_policy" />
	<fmt:message bundle="${loc}" key="locale.index.room_type"
		var="room_type" />
	<fmt:message bundle="${loc}" key="locale.index.room_kind"
		var="room_kind" />
		

<div class="menu">	
	<div class="container clearfix">

		<div id="logo" class="fleft">
			<a href="javascript:void(0);"><img src="images/logo.png" /></a>
		</div>
		<div align="right">
		<a href="Controller?command=change_language&language=ru">${ru}</a>| <a
			href="Controller?command=change_language&language=en">en</a>
	</div>
		<div id="nav" class="fright">
		<form action="Controller" method="post">
		       
			<ul class="navigation">
				<li data-slide="1">${home}</li>
				<li data-slide="2">${about}</li>
				<li data-slide="4"> ${sign_in}</li>
				<li data-slide="10">${contact}</li>
				<div class="clear"></div>
			</ul>
			</form>
		</div>
	
	</div>
</div>


<div class="slide" id="slide1" data-slide="1" data-stellar-background-ratio="0.5">
	<div class="padding_slide1">
		<div class="container clearfix">
			<div id="content" class="grid_12">
				<div class="filtr_bg">
					<p>Make your dreams come true</p>
					<h1>welcome to our hotel</h1>
					<h2>${impressions_title}<br>${stay_title}</h2>
				</div>
				<a class="button" title="" data-slide="8">Book Now</a>
			</div>
		</div>
	</div>
</div>



<div class="slide" id="slide8" data-slide="8" data-stellar-background-ratio="0.5">
	<div class="effect_2 padding_slide8">
		<div class="container clearfix">
			
			<div id="content" class="grid_12">
				<div id="content" class="grid_12">
					<h1>${book}</h1>
					<h2>When would you like to stay at Imperial?</h2>
				</div>
				
				<div class="order_block" align="right">
					
					<form action="Controller" method="post">
		            <input type="hidden" name="command" value="book_room" />
						<label>Type:</label>
						<select name="type" class="makeMeFancy">
							<option value="0" selected="selected" data-skip="1">Select Room Type</option>
							<option value="1 BDRM" data-html-text="1 BDRM&lt;i&gt;&lt;/i&gt;">1 BDRM</option>
							<option value="2 BDRM" data-html-text="2 BDRM&lt;i&gt;&lt;/i&gt;">2 BDRM</option>
							<option value="Apartment" data-html-text="Apartment&lt;i&gt;&lt;/i&gt;">Apartment</option>
							<option value="DeLuxe" data-html-text="DeLuxe&lt;i&gt;&lt;/i&gt;">DeLuxe</option>
							<option value="Duplex" data-html-text="Duplex&lt;i&gt;&lt;/i&gt;">Duplex</option>
							<option value="King suite" data-html-text="King suite&lt;i&gt;&lt;/i&gt;">King suite</option>
							<option value="President" data-html-text="President&lt;i&gt;&lt;/i&gt;">President</option>
							<option value="Family room" data-html-text="Family room&lt;i&gt;&lt;/i&gt;">Family room</option>	
						</select>
						<label>Persons:</label><input type="text" name="people" /><br/><br/>
						<label>Kind:</label><input type="text" name="people" /><br/><br/>
						<label>Your wishes:</label><input type="text" name="message" /><br/><br/>
						<label>From:</label><input type="text" id="datepicker" name="arrive" />
					<label>To:</label><input type="text" id="datepicker2" name="depart" />	
								
					<input type="submit" class="form_btn contact_btn send_btn" value="Book" />
					</form>
					
				</div>
			</div>
		</div>
	</div>
</div>




<div class="slide" id="slide2" data-slide="2" data-stellar-background-ratio="0.5">
	<div class="effect_2 padding_slide2">
		<div class="container clearfix">
			
			<div id="content" class="grid_12">
				<h1>${about}</h1>
			</div>
			
		</div>
	</div>
</div>



<div class="slide" id="slide3" data-slide="3" data-stellar-background-ratio="0.5">
	<div class="container clearfix">

		<div id="content" class="grid_12">
			<img class="about_img" src="images/about_img1.jpg" alt="" />
			<h4>About Us</h4>
			<p>As is to be expected of a five star luxury hotel in the heart of the Swiss Alps, what Imperial Hotel offers, covers every conceivable service and comfort in a house with such lineage and tradition. The well-being of each guest is paramount. It is a maxim that has made this noble house in the heart of Engadin into a world wide celebrity with both young and old. </p>
			<p>The team at Imperial Hotel most definitely understands how to combine contemporary change with the indelible history of the St Moritz symbol. </p>
		<p>This means luxury, lifestyle and a refined champagne-climate in the centre of a unique environment, coupled with attentive service and discretion, highlighted by culinary delicacies and enriched by the tradition of a reputable house that has made friends throughout the world since 1896.</p>
		<p>Your Tradition. Our Spirit.</p>
		</div>

	</div>
</div>
<form action="Controller" method="post">
<div class="slide" id="slide4" data-slide="4" data-stellar-background-ratio="0.5">
	<div class="effect_2 padding_slide4">
		<div class="container clearfix">
			
			<div id="content" class="grid_12">
				<h1><span>${sign_in}</span></h1><br/><br/>
				
				
			<input type="hidden"
							name="command" value="GO_TO_LOGIN" />
				<input type="submit" class="form_btn contact_btn send_btn" value="Sign in" />
			</div>
			
		</div>
	</div>
</div></form>

<div class="slide" id="slide10" data-slide="10" data-stellar-background-ratio="0.5">
	<div class="effect_2 padding_slide10">
		<div class="container clearfix">
			
			<div id="content" class="grid_12">
				<h1><span>Contact</span></h1>
			</div>
			<div class="clear"></div>

		</div>
	</div>
	
</div>



<div class="slide" id="slide11" data-slide="11" data-stellar-background-ratio="0.5">
	<div class="container clearfix">
		
		<div class="grid_3 contact_det_block">
		<p>Thank you for choosing our hotel.</p>
			<p>Your feedback is very important to us, you can leave your comments here</p>
			<ul class="foot_block_intouch">
				<li class="touch_phone"><p>(+1) 245 5462 252</p></li>
				<li class="touch_clock"><p>Mon - Sat 9:00 am - 6:00 pm</p></li>
				<li class="touch_mail"><a href="mailto:support@imperial.com">support@imperial.com</a></li>
				<li class="touch_adress"><p>3301 Los Angeles, S Main St</p></li>
			</ul>
		</div>
		
		<form action="Controller" method="post">
<input type="hidden" name="command" value="give_feedback" /> 
		<div class="grid_9 omega">
			<div class="contact_form">  
				<div id="note"></div>
				<div id="fields">
					<form id="ajax-contact-form" action="">
						<input type="text" name="name" value="" placeholder="Name" />
						<input type="text" name="email" value="" placeholder="Email" />
						<textarea name="message" id="message" placeholder="Message"></textarea>
						<div class="clear"></div>
						<input type="reset" class="contact_btn" value="Clear Form" />
						<input type="submit" class="contact_btn send_btn" value="Send" />
						<div class="clear"></div>
					</form>
				</div>
			</div>
		</div>
		</form>
		<div class="clear"></div>
	
	</div>
	
	<div id="map_block"><iframe width="100%" height="722" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=los+angeles&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=53.080379,114.169922&amp;ie=UTF8&amp;hq=&amp;hnear=Los+Angeles,+California&amp;ll=34.052234,-118.243685&amp;spn=0.003427,0.006968&amp;t=m&amp;z=14&amp;output=embed"></iframe></div>
	
</div>



<div id="footer">
	<div class="container clearfix">
		<div class="copyright">Imperial &copy; 2016 | <a href="javascript:void(0);">${privacy_policy}</a></div>
		<div id="back_top"><a class="button" title="" data-slide="1"></a></div>
	</div>
</div>

</body>
</html>
