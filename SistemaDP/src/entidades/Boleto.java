package entidades;

import java.util.Date;

public class Boleto {

	private int codigoBoleto;
	private Date dataPagamento;
	private Double valorPago;
	private int codFatura;

	public int getCodFatura() {
		return codFatura;
	}

	public void setCodFatura(int codFatura) {
		this.codFatura = codFatura;
	}

	public int getCodigoBoleto() {
		return codigoBoleto;
	}

	public void setCodigoBoleto(int codigoBoleto) {
		this.codigoBoleto = codigoBoleto;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

}
