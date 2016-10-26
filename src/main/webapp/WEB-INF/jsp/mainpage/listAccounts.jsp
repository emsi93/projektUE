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
<title>System wymiany walut - lista kont</title>
<link
	href="/system-exchange-curriencies/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="/system-exchange-curriencies/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Lp.</th>
							<th>Numer konta</th>
							<th>Waluta</th>
							<th>Kraj</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${bankAccountModels }" var="bankAccount"
							varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${bankAccount.numberAccount }</td>
								<td>${bankAccount.carrency }</td>
								<td>${bankAccount.country }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-lg-2"></div>
		</div>
	</div>
</body>
</html>