package entidades;

import java.util.Date;

public class Movimentacao {

	private int codigoMovimentacao;
	private Date dataAtual;
	private int numBoletos;
	private double totalPago;
	private int codFatura;

	public int getCodFatura() {
		return codFatura;
	}

	public void setCodFatura(int codFatura) {
		this.codFatura = codFatura;
	}

	public int getCodigoMovimentacao() {
		return codigoMovimentacao;
	}

	public void setCodigoMovimentacao(int codigoMovimentacao) {
		this.codigoMovimentacao = codigoMovimentacao;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public int getNumBoletos() {
		return numBoletos;
	}

	public void setNumBoletos(int numBoletos) {
		this.numBoletos = numBoletos;
	}

	public double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}

}
