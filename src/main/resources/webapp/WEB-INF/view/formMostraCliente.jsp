<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cliente</title>
	</head>
	<body>
	
	    <form action="${ linkEntradaServlet }" method="POST">
	    	<input type="hidden" name="id" value="${ cliente.id }">
	    	Nome Completo: 
	    	<input type="text" name="nomeCompleto" value="${ cliente.nomeCompleto }"> 
	    	Nome Resumido: 
	    	<input type="text" name="nomeResumido" value="${ cliente.nomeResumido }"> 
	    	Login
	    	<input type="text" name="login" value="${ cliente.login }" />
	    	<input type="hidden" name="acao" value="AlteraCliente"/>
	    	<input type="submit">
		</form>
		
	</body>
</html>