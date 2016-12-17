<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Pagamento</title>
</head>
<body>
	<center>
		<h1>FATURA</h1>
	<hr>
	<form action="listaBoletos.jsp">
		
			<h2>Codigo</h2>
			<input type="text" name="codigoFatura" required placeholder="Apenas numeros" >
			<h2>Vencimento</h2>
			<input type="text" name="dataVencimento" required placeholder="ANO / MES / DIA" >
			<h2>Valor</h2>
			<input type="text" name="valorFatura" required placeholder="Apenas numeros">
			<h2>Cliente</h2>
			<input type="text" name="nomeCliente" required placeholder="Apenas Letras" >
			<h2>Qtd Boletos</h2>
			<input type="text" name="qtdBoletos" required placeholder="Apenas numeros" ><br>
			<br>
			<button type="submit"> Continua </button>
                   
	</form>
	<br>
		</center>

</body>
</html>