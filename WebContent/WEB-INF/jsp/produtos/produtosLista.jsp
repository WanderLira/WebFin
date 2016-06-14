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
	<c:url var="filtrar" value="/produto/filtrar" />
	<c:url var="cadastro" value="/produtos/formCadastro" />
	<c:url var="home" value="/index/principal" />
	<!-- ---------------------------------------------- -->

	<label>LISTA DE PRODUTOS</label>
	<br />
	<br />
	<a href="${home}">Voltar ao Menu</a>
	<br />
	<br />
	<label>Filtro de Lista</label>
	<br />
	<br />
	<form:form action="${filtrar}" method="GET" modelAttribute="filtro">
		<label>Filtrar por Categorias</label>
		<form:select path="categoria.id">
			<form:option value="" label="-- Categorias --" />
			<form:options items="${listaCategoria}" />
		</form:select>

		<label>Filtrar por Descrição</label>
		<form:input path="descricao" />

		<form:button type="submit">Filtrar</form:button>
	</form:form>
	<br />
	<a href="${cadastro}">Novo Produto</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>#</td>
				<td>Descrição do Produto</td>
				<td>Categoria</td>
				<td>Unidade</td>
				<td>Valor</td>
				<td>Quantidade</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${produtos}" varStatus="status">
				<tr>
					<th>${status.count}</th>
					<th>${produto.descricao}</th>
					<th>${produto.categoria.descricao}</th>
					<th>${produto.unidade.descricao}</th>
					<th>${produto.preco}</th>
					<th>${produto.qtdeEstoque}</th>
					<th><a 
						href='<c:url value="/produtos/${produto.id}/formCadastro" />'>Editar</a>
						<a href='<c:url value="/produtos/${produto.id}/remove" />'>Remover</a>
					</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>