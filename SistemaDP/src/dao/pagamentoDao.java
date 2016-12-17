package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Pagamento;

public class pagamentoDao {
	
	private Connection connection;

	public pagamentoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvaPagamento (Pagamento pagamento){
		
		try{
			PreparedStatement stmt;
		String sql2 = "INSERT INTO pagamento (valorPago, dataPagamento, tipoPagamento, codBoleto) VALUES(?,?,?,?)";
		stmt = connection.prepareStatement(sql2);
		stmt.setDouble(1, pagamento.getValorPago());
		stmt.setDate(2, new java.sql.Date(pagamento.getDataPagamento().getTime()));
		stmt.setString(3, pagamento.getTipoPagamento());
		stmt.setInt(4, pagamento.getCodBoleto());
		stmt.execute();

		connection.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	}


}
