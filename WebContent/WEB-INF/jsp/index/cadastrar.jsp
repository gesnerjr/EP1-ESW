<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastrar Pedido zzzzz</title>
</head>
<body>
	Cliente:
	<input type="text" name="pedido.cliente" />
	<br /> Data:
	<input type="text" name="pedido.data" />
	<br /> Valor Total:
	<input type="text" name="pedido.valorTotal" />
	<br />
	<form action=" <c:url value="salvar" />" >
		<input type="submit" value="Salvar" /> 
	</form>
</body>
</html>