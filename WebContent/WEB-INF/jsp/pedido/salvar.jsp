<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Pedido s</title>
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
	<form action="<c:url value="irParaEditar?pedido.id=${pedido.id}"/>">
		<input type="submit" disabled="disabled"
			value="&nbsp;&nbsp;Editar Pedido&nbsp;&nbsp;" />
	</form>
	<br />
	<br /> Pedido Salvo
</body>
</html>