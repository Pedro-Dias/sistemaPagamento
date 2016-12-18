<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Fatura" %>
<%@ page import="entidades.Movimentacao" %>
  
    <%@ page import="dao.faturaDao" %>
    <%@ page import="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="validate/jquery.validate.js"></script> 
<script type="text/javascript" src="validate/jquery-3.1.0.min.js"></script>
<script src = "validate/jquery.js" type = "text/javascript" ></script>
<script src="validate/jquery.maskedinput.js"></script>
<script src="validate/jquery.maskedinput-1.3.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String cod = request.getParameter("codigoFatura");
Fatura fat = new Fatura();                                 
fat.setCodigoFatura(Integer.parseInt(cod));

faturaDao dao = new faturaDao();
List<Fatura> dados = dao.verificar(fat);                 // Verifica se o codigo digitada

int tamanho = 0;                                      // ja existe no banco
for(Fatura tem : dados){
	tamanho = tem.getCodigoFatura();                         
	}

if(tamanho > 0){                                     // se existir da a msg de fatura existente 
 %>
<script>
 setTimeout("window.location='index.jsp'",500);             // retorna para o index
 alert("Fatura Já existe");
</script>
<%
}else{	

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
                                 <!-- this.bt.value='concluido' Apos o envio do form , o input com name "bt" 
                                   muda o seu valor atual para "Concluido" e tambem recebe o disabled  -->
                                   
	<form action='main' target='_blank' onsubmit="this.bt.value='Concluido'; this.bt.disabled=true;">
	
		<center>
			<fieldset>
				<legend><%= num  %>  </legend>
				Codigo Boleto 
				<input type='text' name='codigoBoleto' id='codigoBoleto<%= num  %>' placeholder=' Min 4 Max 8' >
				 Data Pagamento
				 <input type='text' name='dataPagamento' id='dataPagamento<%= num  %>' placeholder=' 00/00/0000'>                
				  Valor Boleto 
				  <input type='text' name='valorBoleto' id='valorBoleto<%= num  %>' placeholder='Min 2 Max 8 Só Numeros '>
				  
				   <input type='hidden' name='tipoBoleto' value='Boleto'>
				  <input type='hidden' name='codFatura' value=<%= fatura.getCodigoFatura()%> > 
				<input type='submit' value='Pagar' id='bt' name='bt'>

			</fieldset>
		</center>
	</form>
	<script type="text/javascript">
jQuery(function($){
    $("#codigoBoleto<%= num  %>").mask("9999?9999");
    $("#dataPagamento<%= num  %>").mask("99/99/9999");
    $("#valorBoleto<%= num  %>").mask("99?999999");
    
})

</script>

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
	<form action='sec'>
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

<% 
}
%>
</body>
</html>