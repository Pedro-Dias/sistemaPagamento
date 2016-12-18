<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validate/jquery.validate.js"></script> 
<script type="text/javascript" src="validate/jquery-3.1.0.min.js"></script>
<script src = "validate/jquery.js" type = "text/javascript" ></script>
<script src="validate/jquery.maskedinput.js"></script>
<script src="validate/jquery.maskedinput-1.3.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Pagamento</title>
</head>
<body>
	<center>
		<h1>FATURA</h1>
	<hr>
	<form action="listaBoletos.jsp">
		
			<h2>Codigo</h2>
			<input type="text" name="codigoFatura" id="codigoFatura" required " placeholder=" Min 4 / Max 8" >
			<h2>Vencimento</h2>
			<input type="text" name="dataVencimento" id="dataVencimento" required " placeholder=" 0000/00/00" >
			<h2>Valor</h2>
			<input type="text" name="valorFatura" id="valorFatura" required " placeholder=" Min 2 Max 6 Só Numeros">
			<h2>Cliente</h2>
			<input type="text" name="nomeCliente" id="nomeCliente" required " placeholder=" Min 12 Max 20 " >
			<h2>Qtd Boletos</h2>
			<input type="text" name="qtdBoletos" id="qtdBoletos" required " placeholder=" Min 1 Max 9" ><br>
			<br>
			<button type="submit"> Continua </button>
                   
	</form>
	<br>
		</center>
		
<script type="text/javascript">
jQuery(function($){
   
    $("#codigoFatura").mask("9999?9999");
    $("#dataVencimento").mask("9999/99/99");
    $("#valorFatura").mask("99?9999");
    $("#qtdBoletos").mask("9");
    
})

</script>

</body>
</html>