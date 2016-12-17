package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Credito;

public class creditoDao {
	
	private Connection connection;

	public creditoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarCredito(Credito cred){
		PreparedStatement stmt;
		try {
		String sql ="INSERT INTO credito (valorCredito, nomeCliente) VALUES (?,?)";
		
		stmt = connection.prepareStatement(sql);
		stmt.setDouble(1, cred.getValorCredito());
		stmt.setString(2, cred.getNomeCliente());
		stmt.execute();
		
		connection.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	}

}
