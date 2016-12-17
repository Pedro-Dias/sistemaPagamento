package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.boletoDao;
import dao.pagamentoDao;
import entidades.Boleto;
import entidades.Pagamento;

@WebServlet("/main")
public class mainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6835408937605904584L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Boleto

		String codigoBoleto = request.getParameter("codigoBoleto");
		String dataPagamento = request.getParameter("dataPagamento");          // Recebendo dados do formulario
		String valorPago = request.getParameter("valorBoleto");
		String codFatura = request.getParameter("codFatura");

		Boleto boleto = new Boleto();
		boleto.setCodigoBoleto(Integer.parseInt(codigoBoleto));

		Date dataConvertida = null;
		try {

			dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(dataPagamento);
		} catch (ParseException e) {
			System.out.println("Erro na conversao da data");
		}
		boleto.setDataPagamento(dataConvertida);
		boleto.setValorPago(Double.parseDouble(valorPago));
		boleto.setCodFatura(Integer.parseInt(codFatura));                         // Chamando o  Dao e salvando boleto

		boletoDao dao = new boletoDao();
		dao.salvaBoleto(boleto);

		// Pagamento

		String tipoBoleto = request.getParameter("tipoBoleto");

		Pagamento pagamento = new Pagamento();
		pagamento.setCodBoleto(Integer.parseInt(codigoBoleto));
		pagamento.setDataPagamento(dataConvertida);                       // Chamando dao e salvando pagamento
		pagamento.setValorPago(Double.parseDouble(valorPago));
		pagamento.setTipoPagamento(tipoBoleto);

		pagamentoDao dao2 = new pagamentoDao();                              
		dao2.salvaPagamento(pagamento);

	}

}
