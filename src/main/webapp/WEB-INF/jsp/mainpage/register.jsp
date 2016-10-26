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
<title>System wymiany walut - rejestracja</title>
<link
	href="/system-exchange-curriencies/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="/system-exchange-curriencies/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body
	background="/system-exchange-curriencies/static/img/background.jpg">
	<div class="container">
		<div class="row">
		</br> </br> </br> </br> </br> </br> </br> </br> 
			<nav id="mainNav" class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> Menu <i
							class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand page-scroll"
						href="/system-exchange-curriencies/mainpage/">System wymiany
						walut</a>
				</div>
			</div>
			</nav>

			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Rejestracja</h3>
					</div>
					<div class="panel-body">
						${wiadomosc}
						*Pola wymagane
						<form:form method="post" modelAttribute="userForm"
							action="/system-exchange-curriencies/mainpage/register/"
							role="form">
							<div class="form-group">
								<label class="sr-only">Imie</label>
								<form:input path="name" type="text" class="form-control"
									placeholder="*Imię..." />
								<div class="errors">
									<form:errors path="name" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Nazwisko</label>
								<form:input path="surname" type="text" class="form-control"
									placeholder="*Nazwisko..." />
								<div class="errors">
									<form:errors path="surname" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Login</label>
								<form:input path="login" type="text" class="form-control"
									placeholder="*Login..." />
								<div class="errors">
									<form:errors path="login" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Hasło</label>
								<form:input path="password" type="password" class="form-control"
									placeholder="*Hasło..." />
								<div class="errors">
									<form:errors path="password" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Powtórz hasło</label>
								<form:input path="password2" type="password"
									class="form-control" placeholder="*Powtórz hasło..." />
								<div class="errors">
									<form:errors path="password2" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Numer telefonu</label>
								<form:input path="phoneNumber" type="text" class="form-control"
									placeholder="*Numer telefonu..." />
								<div class="errors">
									<form:errors path="phoneNumber" element="div" />
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only">Email</label>
								<form:input path="email" type="email" class="form-control"
									placeholder="*Email..." />
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
	</div>
</body>
</html>