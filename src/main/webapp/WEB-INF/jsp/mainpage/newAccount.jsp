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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>System wymiany walut - dodawanie konta</title>
<link href="/system-exchange-curriencies/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/system-exchange-curriencies/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2>Tworzenie nowego konta</h2>
			${wiadomosc }
			*Pola wymagane
			<form:form method="post" modelAttribute="bankAccountForm"
				action="/system-exchange-curriencies/mainpage/newAccount/"
				role="form">
				<div class="form-group">
					<br /> <label>*Numer rachunku:</label>
					<form:input path="numberAccount" type="text" class="form-control"
						placeholder="*Numer rachunku..." />
					<div class="errors">
						<form:errors path="numberAccount" element="div" />
					</div>
				</div>
				<div class="form-group">
					<label>*Waluta rachunku:</label>
					<form:select path="currency" items="${carrienciesISO}"
						class="form-control" />
					<div class="errors">
						<form:errors path="currency" element="div" />
					</div>
				</div>
				<div class="form-group">
					<label>*Kraj:</label>
					<form:select path="country" items="${countries}"
						class="form-control" />
					<div class="errors">
						<form:errors path="country" element="div" />
					</div>
				</div>
				<form:input class="submit btn btn-warning" path="" type="submit"
					value="Dodaj rachunek"></form:input>
			</form:form>


		</div>
	</div>

</body>
</html>