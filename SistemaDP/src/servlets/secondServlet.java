package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.creditoDao;
import dao.faturaDao;
import dao.movimentacaoDao;
import entidades.Credito;
import entidades.Fatura;
import entidades.Movimentacao;

@WebServlet("/sec")
public class secondServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1062717505647680667L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Movimentacao

		String codFatura = request.getParameter("codFatura");
		String qtdBoletos = request.getParameter("qtdBoletos"); // Pegando dados
																// do Formulario
																// "Hidden"
																// no
																// listaBoletos.jsp
		Movimentacao mov = new Movimentacao();
		mov.setCodFatura(Integer.parseInt(codFatura));
		movimentacaoDao dao = new movimentacaoDao();
		List<Movimentacao> dados = dao.Listar(mov);

		double din = 0; // Pegando o valor de todos os boletos com o mesmo
						// codigo da fatura e somando os valores
		double valor = 0;
		for (Movimentacao buscar : dados) {

			din = buscar.getTotalPago();

			din += valor;
			din = (din + din) - din;
			valor = din;

		}
	
		mov.setTotalPago(valor);
		mov.setNumBoletos(Integer.parseInt(qtdBoletos));

		dao.salvarMov(mov); // Chama o  dao e  salvando a movimentacao

		// Credito

		String valorFatura = request.getParameter("valorFatura");
		String nomeCliente = request.getParameter("nomeCliente"); // Pegando
																	// dados do
																	// form
																	// "Hidden"

		Credito cred = new Credito();
		cred.setValorFatura(Double.parseDouble(valorFatura));

		double valorF = 0;
		valorF = cred.getValorFatura(); // Pegando valor da fatura

		double resto = 0;

		if (valorF < valor) { // Vefificando se o valor da Fatura e menor que
								// a soma dos boletos

			resto = valor - valorF;

			cred.setValorCredito(resto);
			cred.setNomeCliente(nomeCliente); // se for menor entra no if
												// preenche objeto,
			creditoDao dao2 = new creditoDao(); //  chama o dao e  cria o
												// credito do cliente

			dao2.salvarCredito(cred);
		}else{
			resto = valor - valorF;
			
		}

		// FATURA

		String dataVencimento = request.getParameter("dtVencimento"); // Pegando
																		// dados
																		// do
																		// form
																		// "Hidden"

		Fatura fatura = new Fatura();

		String stPago = "Pago";
		String stNPago = "Nao Pago";

		if (resto >= 0) { // Variavel "resto" é a variavel do "credito cliente" se for
							// maior ou igual a 0
							// Houve resto em seguida entra no if , preenche o objeto e
							// chama o Dao 

			fatura.setCodigoFatura(Integer.parseInt(codFatura));
			fatura.setDataVencimento(dataVencimento);
			fatura.setValorTotal(Double.parseDouble(valorFatura)); // FATURA
																	// PAGA
			fatura.setNomeCliente(nomeCliente);
			fatura.setStatus(stPago);

			faturaDao dao3 = new faturaDao();
			dao3.salvaFatura(fatura);

		} else { // Se entrou aq é porque a fatura é igual ou Maior que a soma
					// dos boletos

			fatura.setCodigoFatura(Integer.parseInt(codFatura)); // Preenche o
																	// objeto ,
																	// chama o
																	// Dao
			fatura.setDataVencimento(dataVencimento);
			fatura.setValorTotal(Double.parseDouble(valorFatura)); // FATURA NAO
																	// PAGA
			fatura.setNomeCliente(nomeCliente);
			fatura.setStatus(stNPago);

			faturaDao dao3 = new faturaDao();
			dao3.salvaFatura(fatura);
                    
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<script>");
		out.println("setTimeout('window.location='index.jsp'',500);");
		out.println("alert('PAGAMENTO REALIZADO COM SUCESSO ! ! ! ');");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");

	}

}
