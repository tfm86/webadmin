package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class ClienteDAO {

	private Connection connection;

	public ClienteDAO() {

		connection = new ConnectionDB().getConnection();

	}

	public void CloseConnect() throws SQLException {
		connection.close();
	}

	public List<Cliente> listaClienteSistema() throws Exception {

		List<Cliente> lista = new ArrayList<>();
		String sql = "select * from usuario";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet executeQuery = statement.executeQuery();

			while (executeQuery.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(executeQuery.getLong("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setDocumento(executeQuery.getString("documento"));
				cliente.setEmail(executeQuery.getString("email"));
				cliente.setDataCriacao(executeQuery.getString("dataCriacao"));

				lista.add(cliente);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public Cliente buscaClienteId(Long id) throws Exception {

		String sql = "select * from usuario where id=" + id;
		Cliente cliente = new Cliente();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet executeQuery = statement.executeQuery();

			while (executeQuery.next()) {

				cliente.setId(executeQuery.getInt("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setDocumento(executeQuery.getString("documento"));
				cliente.setEmail(executeQuery.getString("email"));
				cliente.setDataCriacao(executeQuery.getString("dataCriacao"));

			}

			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Cliente buscaClienteDocumento(String id) throws Exception {

		String sql = "select * from usuario where documento='" +id+"'";
//		System.out.println(sql);
		Cliente cliente = new Cliente();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet executeQuery = statement.executeQuery();

			while (executeQuery.next()) {

				cliente.setId(executeQuery.getInt("id"));
				cliente.setNome(executeQuery.getString("nome"));
				cliente.setDocumento(executeQuery.getString("documento"));
				cliente.setEmail(executeQuery.getString("email"));
				cliente.setDataCriacao(executeQuery.getString("dataCriacao"));

			}

			return cliente;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void alteraCliente(Cliente cliente) {

		String sql = "update usuario set nome='" + cliente.getNome() + "',documento='" + cliente.getDocumento()
				+ "',email='" + cliente.getEmail() + "' where id=" + cliente.getId();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void novoCliente(Cliente cliente) {

		String sql = "insert into usuario (nome, documento, email, dataCriacao) VALUES(?,?,?,?)";
		try {
			PreparedStatement statament = connection.prepareStatement(sql);
			statament.setString(1, cliente.getNome());
			statament.setString(2, cliente.getDocumento());
			statament.setString(3, cliente.getEmail());
			statament.setString(4, cliente.getDataCriacao());
			statament.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteCliente(int id) {

		String sql = "delete from usuario where id=" + id;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
