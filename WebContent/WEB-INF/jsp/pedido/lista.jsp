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
	<form action=" <c:url value="/" />">
		<input type="submit"
			value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Index&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
	</form>
	<form action="<c:url value="lista" />">
		<input type="submit" readonly="readonly" value="Lista de Pedidos" />
	</form>
	<form action="<c:url value="cadastrar"/>">
		<input type="submit"
			value="&nbsp;&nbsp;&nbsp;Novo Pedido&nbsp;&nbsp;&nbsp;" />
	</form>
	<form action="<c:url value=""/>">
		<input type="submit" value="&nbsp;&nbsp;Editar Pedido&nbsp;&nbsp;" />
	</form>

	<br />
	<br />
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lista
	de Pedidos
	<br />
	<br />
	<table>
		<thead>
			<tr>
				<th>&nbsp;&nbsp;Cliente</th>
				<th>Data</th>
				<th>Itens</th>
				<th>Total R$</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="pedido">
				<tr>

					<td>&nbsp;&nbsp;${pedido.cliente}&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;${pedido.data}&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${pedido.qtdeItens}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;${pedido.valorTotal }&nbsp;&nbsp;</td>
					<td><a href="visualizar?pedido.id=${pedido.id}">Visualizar&nbsp;&nbsp;</a></td>
					<!-- <c:url value="visualizar?pedido.id=${pedido.id}" />-->
					<td><a href="remover?pedido.id=${pedido.id}">Remover</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>