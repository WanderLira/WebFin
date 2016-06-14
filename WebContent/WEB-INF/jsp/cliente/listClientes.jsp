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
	<c:url var="filtrar" value="/cliente/filtrar" />
	<c:url var="home" value="/index/principal" />
	<c:url var="novoCadastro" value="/cliente/formCadastro" />
	<!-- ---------------------------------------------- -->
	
	<label>LISTA DE CLIENTES</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>
	<br />
	<br />
	<label>Filtro de Lista</label>
	<br />
	<br />
	<form:form action="${filtrar}" method="GET" modelAttribute="filtro">
			
		<label>Filtrar por Nome</label>
		<form:input path="nome"/>
		
		<form:button type="submit">Filtrar</form:button>
	</form:form>
	<br />
	<a href="${novoCadastro}">Novo Cliente</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>#</td>
				<td>Nome</td>
				<td>Cpf</td>
				<td>Email</td>
				<td>Telefone</td>
				<td>Celular</td>
				<td>Endereco</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${clientes}" varStatus="status">
			<tr>
				<th>${status.count}</th>
				<th>${cliente.nome}</th>
				<th>${cliente.cpf}</th>
				<th>${cliente.email}</th>
				<th>${cliente.telefone}</th>
				<th>${cliente.celular}</th>
				<th>${cliente.endereco.rua}</th>
				<th>${cliente.endereco.numero}</th>
				<th>${cliente.endereco.complemento}</th>
				<th>${cliente.endereco.bairro}</th>
				<th>${cliente.endereco.cep}</th>
				<th>${cliente.endereco.cidade}</th>
				<th>${cliente.endereco.estado}</th>
				
				<th>
				<a href='<c:url value="/cliente/${cliente.id}/formCadastro" />'>Editar</a>
				<a href='<c:url value="/cliente/${cliente.id}/remove" />'>Remover</a>
				</th>
			</tr>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>