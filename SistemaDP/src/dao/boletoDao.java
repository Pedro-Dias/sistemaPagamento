package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Boleto;


public class boletoDao {
	private Connection connection;

	public boletoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvaBoleto(Boleto boleto) {
		String sql = "INSERT INTO boleto (codigoBoleto, dataPagamento, valorPago, codFatura) VALUES(?,?,?,?)";

		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, boleto.getCodigoBoleto());
			stmt.setDate(2, new java.sql.Date(boleto.getDataPagamento().getTime()));
			stmt.setDouble(3, boleto.getValorPago());
			stmt.setInt(4, boleto.getCodFatura());
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
