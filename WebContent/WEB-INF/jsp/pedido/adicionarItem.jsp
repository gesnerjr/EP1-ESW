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
	<form action="<c:url value="../lista" />">
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
	<br />

	<form>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cliente: <input type="text"
			readonly="readonly" value="${pedido.cliente}" /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Data: <input
			type="text" readonly="readonly" value="${pedido.data}" /> <br />
		Valor Total: <input type="text" readonly="readonly"
			value="${pedido.valorTotal}" /> <br /> <br /> <br /> Itens do
		Pedido <br />
		<form>
			<table>
				<thead>
					<tr>
						<th>&nbsp;&nbsp;Descricao</th>
						<th>Itens</th>
						<th>Valor Unitario</th>
						<th>Valor Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pedido.itens}" var="item">
						<tr>
							<td>&nbsp;&nbsp;${item.descricao}&nbsp;&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;${item.qtde}&nbsp;&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.valorUnitario}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>&nbsp;&nbsp;${item.valorUnitario *
								item.qtde}&nbsp;&nbsp;</td>
							<td><a href="">Remover</a></td>
							<!-- <td><a
								href="../removerItem?pedido.id=${pedido.id}/item.id=${item.id}">Remover</a></td> -->
							<!-- este remover remove o item da lista de itens, como pode nao ter ID, sera de outro modo... -->
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- Verificando a possibilidade de utilizar métodos diretamente do controller sem mudar de página -->
		</form>
	</form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<form action=" <c:url value="?pedido.id=${pedido.id}" />" method="post">

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Descricao: <input type="text"
			name="item.descricao" value="${item.descricao}" /> <br />
		&nbsp;&nbsp;&nbsp;&nbsp;Quantidade: <input type="text"
			name="item.qtde" value="${item.qtde}" /> <br /> Valor Unitario: <input
			type="text" name="item.valorUnitario" value="${item.valorUnitario}" />
		<br /> <input type="submit" value="Adicionar Item" />
	</form>
</body>
</html>