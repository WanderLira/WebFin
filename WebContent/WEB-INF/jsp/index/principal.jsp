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
	
	<c:url var="sair" value="/" />
	<c:url var="listarUsuarios" value="/usuarios/listaUsuarios" />
	<c:url var="listarProdutos" value="/produtos/listarProdutos" />
	<c:url var="listarClientes" value="/cliente/listClientes" />
	<c:url var="listarFornecedores" value="/fornecedor/listFornecedores" />
	<c:url var="listarUnidades" value="/unidade/listUnidades" />
	<c:url var="listarCategorias" value="/categoria/listCategorias" />
	<!-- --------------------------------------------------------- -->

	<label>Bem Vindo ao Sistema</label>
	<br />
	<br />
	<a href="${sair}">Sair do sistema</a>
	<br />
	<br />
	<a href="${listarUsuarios}">Cadastro Usuário</a>&nbsp;
	<a href="${listarCategorias}">Cadastro Categoria</a>&nbsp;
	<a href="${listarUnidades }">Cadastro Unidade</a>&nbsp;
	<a href="${listarProdutos}">Cadastro Produto</a>&nbsp;
	<a href="${listarClientes}">Cadastro Cliente</a>&nbsp;
	<a href="${listarFornecedores }">Cadastro Fornecedor</a>
</body>
</html>