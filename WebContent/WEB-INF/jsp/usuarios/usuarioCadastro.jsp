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
	<c:url var="listarUsuarios" value="/usuarios/listaUsuarios" />
	<c:url var="cadastro" value="/usuarios/cadastrar" />
	<c:url var="home" value="/index/principal" />
	<!-- ---------------------------------------------- -->

	<label>CADASTRO DE USUÁRIO</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>&nbsp;
	<a href="${listarUsuarios}">Voltar para Lista</a>
	<br />
	<br />
	<label>Formulário de Cadastro</label>
	<br />
	<br />
	<form:form action="${cadastro}" method="POST" modelAttribute="usuario">
		<form:hidden path="id" />
		<label>Nome do Usuário</label>
		<form:input path="nome" />
		<label>Matricula</label>
		<form:input path="matricula" />
		<label>Login</label>
		<form:input path="login" />
		<label>Senha</label>
		<form:input path="senha" />
		<form:button type="submit">Cadastrar</form:button>
	</form:form>

</body>
</html>