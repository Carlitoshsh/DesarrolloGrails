<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="shortcut icon" href="../../docs-${request.contextPath}/theme/assets/ico/favicon.png">

		<title>Bienvenido a Forum 2.0 </title>

		<!-- Bootstrap core CSS -->
		<link href="${request.contextPath}/theme/assets/css/bootstrap.css" rel="stylesheet">


		<!-- Custom styles for this template -->
		<link href="${request.contextPath}/theme/assets/css/main.css" rel="stylesheet">

		<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
		<script src="${request.contextPath}/theme/assets/js/hover.zoom.js"></script>
		<script src="${request.contextPath}/theme/assets/js/hover.zoom.conf.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
      	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    	<![endif]-->
		<g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	<div class="container" >
		<center><img class= "text-vertical-center" src="${request.contextPath}/theme/assets/img/forum.png" width="200px" height="auto"/></center>
	</div>

	<!-- Static navbar -->
	<div class="navbar">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<p class="navbar-brand">FORUM 2.0</p>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="work.html">Mi Perfil</a></li>
					<li><a href="about.html">Mis Post</a></li>
					<li><a href="blog.html">Logout</a></li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div>

		<div id="create-admin" class="container" align = "center" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" align = "center" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${adminInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${adminInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:adminInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
