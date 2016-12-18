<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="entidades.Fatura" %>
    <%@ page import="dao.faturaDao" %>
    <%@ page import="java.util.List" %>
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
String cod = request.getParameter("codigoFatura");

Fatura fat = new Fatura();
fat.setCodigoFatura(Integer.parseInt(cod));

faturaDao dao = new faturaDao();
List<Fatura> dados = dao.verificar(fat);

int tamanho = 0;
for(Fatura tem : dados){
	tamanho = tem.getCodigoFatura();
	}

if(tamanho > 0){
 %>
<script>
 setTimeout("window.location='index.jsp'",500);
 alert("Codigo da Fatura Já existe");
</script>
<%
}else{	
%>
	<script>
window.location.href = "listaBoletos.jsp";
	</script>
<% 
}
%>
</body>
</html>