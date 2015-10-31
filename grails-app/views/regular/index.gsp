
<%@ page import="testdesarrollo.Regular" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'regular.label', default: 'Regular')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-regular" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-regular" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'regular.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="lastname" title="${message(code: 'regular.lastname.label', default: 'Lastname')}" />
					
						<g:sortableColumn property="age" title="${message(code: 'regular.age.label', default: 'Age')}" />
					
						<g:sortableColumn property="username" title="${message(code: 'regular.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'regular.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="postViews" title="${message(code: 'regular.postViews.label', default: 'Post Views')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${regularInstanceList}" status="i" var="regularInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${regularInstance.id}">${fieldValue(bean: regularInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: regularInstance, field: "lastname")}</td>
					
						<td>${fieldValue(bean: regularInstance, field: "age")}</td>
					
						<td>${fieldValue(bean: regularInstance, field: "username")}</td>
					
						<td>${fieldValue(bean: regularInstance, field: "password")}</td>
					
						<td>${fieldValue(bean: regularInstance, field: "postViews")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${regularInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
