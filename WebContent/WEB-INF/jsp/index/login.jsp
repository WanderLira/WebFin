<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Financeiro</title>
</head>
<body>
<!-- URLS PARA ACESSO OS CONTROLES -->
	<c:url var="logar" value="/logar" />
	<!-- ------------------------------------------------ -->
	<label>Entre com o login e senha!</label>
	<br />
	<br />
	
	<form:form action="${logar}" method="POST" modelAttribute="usuario">
		<label>Login</label>
		<form:input path="login" autofocus="autofocus"/>
		<label>Senha</label>
		<form:input path="senha"/>
		<form:button type="submit">Acessar</form:button>	
	</form:form>
</body>
</html>