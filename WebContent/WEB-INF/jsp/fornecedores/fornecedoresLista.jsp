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
	<c:url var="filtrar" value="/clinte/filtrar" />
	<c:url var="home" value="/index/principal" />
	<c:url var="novoCadastro" value="/fornecedor/formCadastro" />
	<!-- ---------------------------------------------- -->
	
	<label>LISTA DE FORNECEDORES</label>
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
	<a href="${novoCadastro}">Novo Fornecedor</a>
	<hr>
	<table>
		<thead>
			<tr>
				<td>#</td>
				<td>Nome</td>
				<td>Cnpj</td>
				<td>Email</td>
				<td>Telefone</td>				
				<td>Endereco</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="fornecedor" items="${fornecedores}" varStatus="status">
			<tr>
				<th>${status.count}</th>
				<th>${fornecedor.nome}</th>
				<th>${fornecedor.cnpj}</th>
				<th>${fornecedor.email}</th>
				<th>${fornecedor.telefone}</th>				
				<th>${fornecedor.endereco.rua}</th>
				<th>${fornecedor.endereco.numero}</th>
				<th>${fornecedor.endereco.complemento}</th>
				<th>${fornecedor.endereco.bairro}</th>
				<th>${fornecedor.endereco.cep}</th>
				<th>${fornecedor.endereco.cidade}</th>
				<th>${fornecedor.endereco.estado}</th>
				
				<th>
				<a href='<c:url value="/fornecedor/${fornecedor.id}/formCadastro" />'>Editar</a>
				<a href='<c:url value="/fornecedor/${fornecedor.id}/remove" />'>Remover</a>
				</th>
			</tr>
			</c:forEach>
		</tbody>	
	</table>
</body>
</html>