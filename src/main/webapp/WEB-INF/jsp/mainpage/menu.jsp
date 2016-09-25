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
<title>System wymiany walut - menu</title>
<link
	href="/system-exchange-curriencies/static/menu/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/system-exchange-curriencies/static/menu/css/sb-admin.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="/system-exchange-curriencies/static/menu/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/system-exchange-curriencies/static/menu/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery -->
<script src="/system-exchange-curriencies/static/menu/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="/system-exchange-curriencies/static/menu/js/bootstrap.min.js"></script>

<!-- Morris Charts JavaScript -->
<script
	src="/system-exchange-curriencies/static/menu/js/plugins/morris/raphael.min.js"></script>
<script
	src="/system-exchange-curriencies/static/menu/js/plugins/morris/morris.min.js"></script>
<script
	src="/system-exchange-curriencies/static/menu/js/plugins/morris/morris-data.js"></script>
</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="menu">System wymiany</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">



			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"><i class="fa fa-user"></i> User<b
					class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a class="submit" id="twojProfil1"><i
							class="fa fa-fw fa-user"></i>Edytuj profil</a></li>
					<li><a href="#"><i class="fa fa-fw fa-gear"></i> Wyloguj</a></li>
				</ul></li>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#demo"><i class="glyphicon glyphicon-euro"></i>Operacje<i
						class="fa fa-fw fa-caret-down"></i></a>
					<ul id="demo" class="collapse">
						<li><a href="javascript:;" class="submit" id="sprzedajWalute">Sprzedaj walutę</a>
						</li>
						<li><a href="javascript:;" class="submit" id="kupWalute">Kup walutę</a></li>
						<li><a href="javascript:;" class="submit" id="wymienWalute">Wymień walutę</a></li>
					</ul></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#demo2"><i class="glyphicon glyphicon-briefcase"></i>Rachunki
						bankowe<i class="fa fa-fw fa-caret-down"></i></a>
					<ul id="demo2" class="collapse">
						<li><a href="javascript:;" class="submit" id="listaRachunkow">Lista rachunków</a>
						</li>
						<li><a href="javascript:;" class="submit" id="dodajRachunek">Dodaj rachunek</a></li>
					</ul></li>
				<li><a href="javascript:;" class="submit" id="historiaOperacji"><i
						class="fa fa-fw fa-history"></i>Historia operacji</a></li>

				<li><a href="javascript:;" type="submit" id="twojProfil"><i
						class="glyphicon glyphicon-user"></i> Twój profil</a></li>

				<li><a href="javascript:;" class="submit" id="dodajOdbiorce"><i
						class="glyphicon glyphicon-plus"></i>Dodaj odbiorcę</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<center>
							<div style="display: block" id="firstView">Pierwszy widok
							</div>
							<div style="display: none" id="viewSprzedajWalute">siema1a
							</div>
							<div style="display: none" id="viewKupWalute">siema1b</div>
							<div style="display: none" id="viewWymienWalute">siema1c</div>
							<div style="display: none" id="viewListaRachunkow">siema2a
							</div>
							<div style="display: none" id="viewDodajRachunek">siema2b</div>
							<div style="display: none" id="viewHistoriaOperacji">
								siema3</div>
							<div style="display: none" id="viewTwojProfil">siema4</div>
							<div style="display: none" id="viewDodajOdbiorce">siema5</div>
						</center>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->



</body>
<style>
div.content2 {
	position: absolute;
	left: 0;
	bottom: 0;
	right: 0
}
</style>
<script>
	$("#sprzedajWalute").click(function() {
		document.getElementById("viewSprzedajWalute").style.display = "block";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("firstView").style.display = "none";

	});
	$("#kupWalute").click(function() {
		document.getElementById("viewKupWalute").style.display = "block";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("firstView").style.display = "none";

	});
	$("#wymienWalute").click(function() {
		document.getElementById("viewWymienWalute").style.display = "block";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("firstView").style.display = "none";

	});
	$("#listaRachunkow").click(function() {
		document.getElementById("viewListaRachunkow").style.display = "block";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("firstView").style.display = "none";
	});
	$("#dodajRachunek").click(function() {
		document.getElementById("viewDodajRachunek").style.display = "block";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("firstView").style.display = "none";
	});
	$("#historiaOperacji")
			.click(
					function() {
						document.getElementById("viewHistoriaOperacji").style.display = "block";
						document.getElementById("viewTwojProfil").style.display = "none";
						document.getElementById("viewDodajOdbiorce").style.display = "none";
						document.getElementById("viewListaRachunkow").style.display = "none";
						document.getElementById("viewSprzedajWalute").style.display = "none";
						document.getElementById("viewKupWalute").style.display = "none";
						document.getElementById("viewWymienWalute").style.display = "none";
						document.getElementById("viewDodajRachunek").style.display = "none";
						document.getElementById("firstView").style.display = "none";
					});
	$("#twojProfil").click(function() {
		document.getElementById("viewTwojProfil").style.display = "block";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("firstView").style.display = "none";
	});
	$("#twojProfil1").click(function() {
		document.getElementById("viewTwojProfil").style.display = "block";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewDodajOdbiorce").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("firstView").style.display = "none";
	});
	$("#dodajOdbiorce").click(function() {
		document.getElementById("viewDodajOdbiorce").style.display = "block";
		document.getElementById("viewHistoriaOperacji").style.display = "none";
		document.getElementById("viewTwojProfil").style.display = "none";
		document.getElementById("viewListaRachunkow").style.display = "none";
		document.getElementById("viewSprzedajWalute").style.display = "none";
		document.getElementById("viewKupWalute").style.display = "none";
		document.getElementById("viewWymienWalute").style.display = "none";
		document.getElementById("viewDodajRachunek").style.display = "none";
		document.getElementById("firstView").style.display = "none";
	});
</script>
</html>
