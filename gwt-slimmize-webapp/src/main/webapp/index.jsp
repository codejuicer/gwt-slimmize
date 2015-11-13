<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>

<c:set var="title" value="wUnit Prototype" />

<!DOCTYPE html>
<html>

<head>
<meta name="description" content="Unit Test framework for Warhammer 40K">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title><c:out value="${title}" /></title>

<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
<meta name="application-name" content="wUnit">

<script src="bower_components/webcomponentsjs/webcomponents-lite.js"></script>
<link rel="import" href="elements/wunit-unit.html">
<link rel="import" href="elements/wunit-game.html">
<link rel="import" href="elements/wunit-log.html">

<link rel="stylesheet" media="screen" href="styles/bootstrap.min.css">
</head>

<body>	
	
	<nav class="navbar navbar-default" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><c:out value="${title}" /></a>
		</div>
	
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Game</a></li>
				<li><a href="todo.html">Editor</a></li>
			</ul>
		</div><!-- /.navbar-collapse -->
	</nav>

	<div class="container">
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			<div class="panel panel-default">
				<div class="panel-body">
				   Demo using <a href="dev.jsp">SSO linker</a>
				</div>
			</div>
		</div>
		<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			<div class="panel panel-default">
				<div class="panel-body">
				   Demo using <a href="dev.xsi.jsp">XSI linker</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

