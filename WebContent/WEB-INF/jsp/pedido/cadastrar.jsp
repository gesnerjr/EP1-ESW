<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Pedido</title>
</head>
<body>
	<form action=" <c:url value="/" />">
		<input type="submit"
			value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Index&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" />
	</form>
	<form action="<c:url value="lista" />">
		<input type="submit" value="Lista de Pedidos" />
	</form>
	<form action="<c:url value="cadastrar"/>">
		<input type="submit" readonly="readonly"
			value="&nbsp;&nbsp;&nbsp;Novo Pedido&nbsp;&nbsp;&nbsp;" />
	</form>
	<form action="<c:url value=""/>">
		<input type="submit" value="&nbsp;&nbsp;Editar Pedido&nbsp;&nbsp;" />
	</form>
	<br />
	<br />


	<form action=" <c:url value="salvar" />" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cliente: <input type="text"
			name="pedido.cliente" value="${pedido.cliente}" /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data: <input
			type="text" name="pedido.data" value="${pedido.data}" /> <br />
		<!-- Valor Total: <input type="text" readonly="readonly"	value="${pedido.valorTotal}" /> <br /> -->
		<input type="submit" value="Salvar Pedido" />
	</form>
</body>
</html>