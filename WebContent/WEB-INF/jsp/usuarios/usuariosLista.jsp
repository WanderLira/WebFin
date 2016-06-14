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
	<c:url var="filtrar" value="/usuarios/filtrar" />
	<c:url var="home" value="/index/principal" />
	<c:url var="novoCadastro" value="/usuarios/formCadastro" />
	<!-- ---------------------------------------------- -->
	
	<label>LISTA DE USUÁRIOS</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>
	<br />
	<br />
	<label>Filtro de Lista</label>
	<br />
	<br />
	<form:form action="${filtrar}" method="GET" modelAttribute="filtro">
		<label>Filtrar por Login</label>
		<form:input path="login"/>
		
		<label>Filtrar por Nome</label>
		<form:input path="nome"/>
		
		<form:button type="submit">Filtrar</form:button>
	</form:form>
	<br />
	<a href="${novoCadastro}">Novo Usuário</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>#</td>
				<td>Nome Usuarios</td>
				<td>Matricula</td>
				<td>Login</td>
				<td>AÇÕES</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="usuario" items="${usuarios}" varStatus="status">
			<tr>
				<th>${status.count}</th>
				<th>${usuario.nome}</th>
				<th>${usuario.matricula}</th>
				<th>${usuario.login}</th>
				<th>
				<a href='<c:url value="/usuarios/${usuario.id}/formCadastro" />'>Editar</a>
				<a href='<c:url value="/usuarios/${usuario.id}/remove" />'>Remover</a>
				</th>
			</tr>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>