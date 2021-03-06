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
	<c:url var="listClientes" value="/cliente/listClientes" />
	<c:url var="cadastro" value="/cliente/cadastrar" />
	<c:url var="home" value="/index/principal" />
	<!-- ---------------------------------------------- -->

	<label>CADASTRO DE CLIENTE</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>&nbsp;&nbsp;
	<a href="${listClientes}">Voltar para Lista</a>
	<br />
	<br />
	<label>Formulário de Cadastro</label>
	<br />
	<br />
	<form:form action="${cadastro}" method="POST" modelAttribute="cliente">
		<form:hidden path="id" />
		<label>Nome do Cliete</label>
		<form:input path="nome" />
		<label>Cpf</label>
		<form:input path="cpf" />
		<label>Email</label>
		<form:input path="email" />
		<label>Telefone</label>
		<form:input path="telefone" />
		<label>Celular</label>
		<form:input path="celular" />
		<label>Rua</label>
		<form:input path="endereco.rua" />
		<label>Numero</label>
		<form:input path="endereco.numero" />
		<label>Complemento</label>
		<form:input path="endereco.complemento" />
		<label>Bairro</label>
		<form:input path="endereco.bairro" />
		<label>cep</label>
		<form:input path="endereco.cep" />
		<label>Cidade</label>
		<form:input path="endereco.cidade" />
		<label>Estado</label>
		<form:input path="endereco.estado" />
		
		
		
		<form:button type="submit">Cadastrar</form:button>
	</form:form>

</body>
</html>