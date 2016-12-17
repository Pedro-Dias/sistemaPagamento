package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import entidades.Fatura;

public class faturaDao {

	private Connection connection;

	public faturaDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void salvaFatura(Fatura fatura) {

		String sql = "INSERT INTO fatura (codigoFatura, dataVencimento, valorTotal, nomeCliente, Status) VALUES (?,?,?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, fatura.getCodigoFatura());
			stmt.setString(2, fatura.getDataVencimento());
			stmt.setDouble(3, fatura.getValorTotal());
			stmt.setString(4, fatura.getNomeCliente());
			stmt.setString(5, fatura.getStatus());
			stmt.execute();

			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
