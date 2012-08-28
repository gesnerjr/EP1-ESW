<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-br" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Pedidos</title>
</head>
<body>

	Lista de Pedidos
	<br />
	<ul>
		<li>Cliente - Data do Pedido - Quantidade de Itens - Valor Total</li>
		<br />
		<c:forEach items="${list}" var="pedido">
			<li>${pedido.cliente} - ${pedido.dataFormatada} -
				${pedido.qtdeItens} - ${pedido.valorTotal} - Visualizar Pedido -
				Remover Pedido</li>
		</c:forEach>
	</ul>

	<table>
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Data</th>
				<th>Quantidade de Itens</th>
				<th>Valor Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="pedido">
				<tr>
					<td>${pedido.cliente}</td>
					<td>${pedido.dataFormatada}</td>
					<td>${pedido.qtdeItens}</td>
					<td>${pedido.valorTotal }</td>
					<td><a href="edita?id=${pedido.id}">Editar</a></td>
					<td><a href="remove?id=${pedido.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>