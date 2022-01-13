package br.com.fns.mecanica.acao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory conexao = new ConnectionFactory();
		Connection connection = conexao.recuperarConexao();

		listaProdutos(connection);
		insereProduto(connection);
		deletaProduto(connection);
		testaInsercaoComParametros(connection);
		listaProdutos(connection);
		deletaProdutoUsandoPreparedStatement(connection);
		listaProdutosUsandoPreparementStatement(connection);
		testaInsercaoComParametros(connection);
		listaProdutosUsandoPreparementStatement(connection);

		System.out.println("Fechando conexão! !");

		connection.close();
	}

	private static void listaProdutos(Connection connection) throws SQLException {

		Statement stm = connection.createStatement();

		stm.execute(" SELECT ID, NOME, DESCRICAO FROM produto");

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
	}

	private static void listaProdutosUsandoPreparementStatement(Connection connection) throws SQLException {

		PreparedStatement stm = connection.prepareStatement(" SELECT ID, NOME, DESCRICAO FROM produto ");

		stm.execute();

		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			Integer id = rst.getInt("ID");
			System.out.println(id);
			String nome = rst.getString("NOME");
			System.out.println(nome);
			String descricao = rst.getString("DESCRICAO");
			System.out.println(descricao);
		}
	}

	private static void insereProduto(Connection connection) throws SQLException {

		Statement stm = connection.createStatement();

		stm.execute(" INSERT INTO produto (nome, descricao) values ('Mouse','Mouse sem fio')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id retornado foi: " + id);
		}
	}

	private static void deletaProduto(Connection connection) throws SQLException {

		Statement stm = connection.createStatement();

		stm.execute(" DELETE FROM produto WHERE id > 2");

		Integer qtdLinhasModificadas = stm.getUpdateCount();
		System.out.println("Foram modificadas: " + qtdLinhasModificadas + " linhas.");

	}

	private static void deletaProdutoUsandoPreparedStatement(Connection connection) throws SQLException {

		PreparedStatement stm = connection.prepareStatement(" DELETE FROM produto WHERE id > ? ");
		stm.setInt(1, 2);

		stm.execute();

		Integer qtdLinhasModificadas = stm.getUpdateCount();
		System.out.println("Foram modificadas: " + qtdLinhasModificadas + " linhas.");

	}

	private static void testaInsercaoComParametros(Connection connection) throws SQLException {
		String nome = "Mouse'";
		String descricao = "Mouse se fio); delete from produto;";

		PreparedStatement stm = connection.prepareStatement("Insert into produto (nome, descricao) values (?,?)",
				Statement.RETURN_GENERATED_KEYS);

		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O id retornado foi: " + id);
		}

	}

}
