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
	<c:url var="listaCategorias" value="/categoria/listCategorias" />
	<c:url var="cadastro" value="/categoria/cadastrar" />
	<c:url var="home" value="/index/principal" />
	<!-- ---------------------------------------------- -->

	<label>CADASTRO DE UNIDADE</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>&nbsp;&nbsp;
	<a href="${listaCategorias}">Voltar para Lista</a>
	<br />
	<br />
	<label>Formulário de Cadastro</label>
	<br />
	<br />
	<form:form action="${cadastro}" method="POST" modelAttribute="categoria">
		<form:hidden path="id" />
		<label>Descricao da Categoria</label>
		<form:input path="descricao" />
		
		<form:button type="submit">Cadastrar</form:button>
	</form:form>

</body>
</html>