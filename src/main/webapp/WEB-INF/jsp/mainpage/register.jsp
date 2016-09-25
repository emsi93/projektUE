<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" isELIgnored="false"
	contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>System wymiany walut</title>
<link
	href="/system-exchange-curriencies/static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/system-exchange-curriencies/static/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>

<!-- Plugin CSS -->
<link
	href="/system-exchange-curriencies/static/vendor/magnific-popup/magnific-popup.css"
	rel="stylesheet">

<!-- Theme CSS -->
<link href="/system-exchange-curriencies/static/css/creative.min.css"
	rel="stylesheet">
<link href="/system-exchange-curriencies/static/css/errors.css"
	rel="stylesheet">

<!-- jQuery -->
<script
	src="/system-exchange-curriencies/static/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="/system-exchange-curriencies/static/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Plugin JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
<script
	src="/system-exchange-curriencies/static/vendor/scrollreveal/scrollreveal.min.js"></script>
<script
	src="/system-exchange-curriencies/static/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

<!-- Theme JavaScript -->
<script src="/system-exchange-curriencies/static/js/creative.min.js"></script>
</head>
<body class="bg-primary">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll"
				href="/system-exchange-curriencies/mainpage/">System wymiany</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a class="page-scroll"
					href="/system-exchange-curriencies/mainpage/about">O nas</a></li>
				<li><a class="page-scroll"
					href="/system-exchange-curriencies/mainpage/login">Zaloguj</a></li>
				<li><a class="page-scroll"
					href="/system-exchange-curriencies/mainpage/register">Rejestracja</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 text-center" style="top: 150px">
				<h2 class="section-heading">Rejestracja:</h2>
				<hr class="light">
				<div class="col-sm-6 col-sm-offset-3 form-box text-left">
					<h5 class="section-heading">*Pola wymagane</h5>
					<label>${wiadomosc }</label>
					<form:form method="post" modelAttribute="userForm" action="/system-exchange-curriencies/mainpage/register/" role="form">
						<div class="form-group">
							<label class="sr-only">Imie</label>
							<form:input path="name" type="text" class="form-control" placeholder="*Imię..."/>
							<div class="errors">
								<form:errors path="name" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Nazwisko</label> 
							<form:input path="surname" type="text" class="form-control" placeholder="*Nazwisko..."/>
							<div class="errors">
								<form:errors path="surname" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Login</label>
							<form:input path="login" type="text" class="form-control" placeholder="*Login..."/>
							<div class="errors">
								<form:errors path="login" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Hasło</label>
							<form:input path="password" type="password" class="form-control" placeholder="*Hasło..."/>
							<div class="errors">
								<form:errors path="password" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Powtórz hasło</label>
							<form:input path="password2" type="password" class="form-control" placeholder="*Powtórz hasło..."/>
							<div class="errors">
								<form:errors path="password2" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Numer telefonu</label>
							<form:input path="phoneNumber" type="text" class="form-control" placeholder="*Numer telefonu..."/>
							<div class="errors">
								<form:errors path="phoneNumber" element="div" />
							</div>
						</div>
						<div class="form-group">
							<label class="sr-only">Email</label>
							<form:input path="email" type="email" class="form-control" placeholder="*Email..."/>
							<div class="errors">
								<form:errors path="email" element="div" />
							</div>
						</div>
						<div>
					<form:input class="submit btn btn-primary" path="" type="submit"
						value="Zakończ rejestrację"></form:input>
				</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>