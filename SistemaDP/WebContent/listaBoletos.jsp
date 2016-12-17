<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Fatura" %>
<%@ page import="entidades.Movimentacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String qtdBoletos = request.getParameter("qtdBoletos");
	    String codFatura = request.getParameter("codigoFatura");
	    String valorFatura = request.getParameter("valorFatura");           // Pegando dados do formulario da Fatura
	    String nomeCliente = request.getParameter("nomeCliente");
	    String dataVencimento = request.getParameter("dataVencimento");
		int boletos;
		int num = 1;
		boletos = Integer.parseInt(qtdBoletos);
		
		
		Fatura fatura = new Fatura();
		fatura.setCodigoFatura(Integer.parseInt(codFatura));
		fatura.setValorTotal(Double.parseDouble(valorFatura));
		fatura.setNomeCliente(nomeCliente);
		fatura.setDataVencimento(dataVencimento);
		
		while (boletos > 0) {
	%>

	<form action='main' target='_blank'>
		<center>
			<fieldset>
				<legend><%= num  %>  </legend>
				Codigo Boleto 
				<input type='text' name='codigoBoleto'  >
				 Data Pagamento
				 <input type='text' name='dataPagamento'  >                
				  Valor Boleto 
				  <input type='text' name='valorBoleto'>
				   <input type='hidden' name='tipoBoleto' value='Boleto'>
				  <input type='hidden' name='codFatura' value=<%= fatura.getCodigoFatura()%> > 
				<input type='submit' value='salvar'>

			</fieldset>
		</center>
	</form>
	

<%

boletos -= 1;         // Evitando Loop infinito
num += 1;   
	
		}
	%>
	<%
	Movimentacao mov = new Movimentacao();
	mov.setNumBoletos(Integer.parseInt(qtdBoletos));
	%>
	
	<!--  dados a serem reutilizados  no Segundo servlet Servlet -->
	<form action='sec' target='_blank'>
		<center>
			<fieldset>
				  <input type='hidden' name='codFatura' value=<%= fatura.getCodigoFatura()%> > 
				   <input type='hidden' name='qtdBoletos' value=<%= mov.getNumBoletos()%> >
				   <input type='hidden' name='valorFatura' value=<%= fatura.getValorTotal()%> >
				   <input type='hidden' name='nomeCliente' value=<%= fatura.getNomeCliente()%> >
				   <input type='hidden' name='dtVencimento' value=<%= fatura.getDataVencimento()%> >
				   
				<input type='submit' value='Continuar'>

			</fieldset>
		</center>
	</form>

</body>
</html>