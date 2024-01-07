package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.UsuarioSistema;

public class UsuarioSistemaDAO {

	private Connection connection;

	public UsuarioSistemaDAO() {

		connection = new ConnectionDB().getConnection();

	}

	public List<UsuarioSistema> listaUsuarioSistema() throws Exception {

		List<UsuarioSistema> lista = new ArrayList<>();
		String sql = "select * from sistema";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet executeQuery = statement.executeQuery();

			while (executeQuery.next()) {

				UsuarioSistema o = new UsuarioSistema();
				o.setId(executeQuery.getLong("id"));
				o.setLogin(executeQuery.getString("login"));
				o.setSenha(executeQuery.getString("senha"));
				o.setDataCriacao(executeQuery.getString("dataCriacao"));

				lista.add(o);

			}

			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return lista;
	}

	public UsuarioSistema buscaUsuarioUser(String user) throws Exception {

		String sql = "select * from sistema where login='" + user + "'";

		UsuarioSistema u = new UsuarioSistema();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet executeQuery = statement.executeQuery();

			while (executeQuery.next()) {

				u.setId(executeQuery.getInt("id"));
				u.setLogin(executeQuery.getString("login"));
				u.setSenha(executeQuery.getString("senha"));
				u.setDataCriacao(executeQuery.getString("dataCriacao"));

			}

			connection.close();
			return u;

		} catch (SQLException e) {

			connection.close();
			return null;
		}

	}

}
