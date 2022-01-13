<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, br.com.fns.mecanica.modelo.Cliente"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clientes</title>
</head>
<body>
<%-- 	<c:if test="${ not empty usuarioLogado }"> --%>
<%-- 			<c:import url="logout-parcial.jsp"></c:import> --%>
			
<%-- 			Usuário Logado: ${ usuarioLogado.login } --%>
<!-- 			<br /> -->
<!-- 			<br /> -->
<%-- 	</c:if> --%>

<%-- 	<c:if test="${ not empty empresa }"> --%>
<%-- 			Empresa ${ empresa } cadastrada com sucesso! --%>
<!-- 			<br /> -->
<!-- 		<br /> -->
<%-- 	</c:if> --%>
	
	<br /> Lista de Clientes:
	<c:if test="${ not empty clientes }">
		<ul>
			<c:forEach items="${ clientes }" var="cliente">
				<li>
					${ cliente.nomeResumido }
					<a href="${ linkEntradaServlet }?acao=RemoveCliente&id=${ cliente.id }">Remover</a>
					<a href="${ linkEntradaServlet }?acao=MostraCliente&id=${ cliente.id }">Editar</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${ empty clientes }">
		Lista de clientes vazia.
	</c:if>
</body>
</html>