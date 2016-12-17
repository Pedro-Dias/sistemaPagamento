package entidades;

import java.util.Date;

public class Credito {

	private double codigoCredito;
	private double valorCredito;
	private String nomeCliente;
	private Date dataEmissao;
	private double valorFatura;
	

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public double getCodigoCredito() {
		return codigoCredito;
	}

	public void setCodigoCredito(double codigoCredito) {
		this.codigoCredito = codigoCredito;
	}

	public double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}
