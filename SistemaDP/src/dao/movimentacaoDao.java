package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Movimentacao;

public class movimentacaoDao {

	private Connection connection;

	public movimentacaoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Movimentacao> Listar(Movimentacao mov) {

		try {
			PreparedStatement stmt;

			List<Movimentacao> dados = new ArrayList<Movimentacao>();

			String sql = "SELECT valorPago from boleto WHERE codFatura=?";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, mov.getCodFatura());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Movimentacao move = new Movimentacao();
				move.setTotalPago(rs.getDouble("valorPago"));
				dados.add(move);

			}

			rs.close();
			
			return dados;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void salvarMov(Movimentacao move){
		
		try {
			PreparedStatement stmt;
			
			String sql = "INSERT INTO mov (numBoletos, totalPago) VALUES (?,?)";
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, move.getNumBoletos());
			stmt.setDouble(2, move.getTotalPago());
			stmt.execute();
			connection.close();
	} catch (SQLException e) {
		throw new RuntimeException(e);
	}
	}
}
