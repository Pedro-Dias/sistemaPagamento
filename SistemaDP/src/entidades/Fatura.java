package entidades;

public class Fatura {

	private int codigoFatura;
	private String dataVencimento;
	private double valorTotal;
	private String nomeCliente;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCodigoFatura() {
		return codigoFatura;
	}

	public void setCodigoFatura(int codigoFatura) {
		this.codigoFatura = codigoFatura;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

}
