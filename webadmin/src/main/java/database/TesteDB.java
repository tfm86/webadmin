package database;


import org.junit.jupiter.api.Test;

import modelo.Cliente;

public class TesteDB {

//	@Test
//	public void initDatabase() {
//
//		new ConnectionDB().Connect();
//
//	}
//
//	@Test
//	public void ListarCliente() throws Exception {
//
//		ClienteDAO dao = new ClienteDAO();
//		System.out.println(dao.listaClienteSistema());
//
//	}
//
//	@Test
//	public void ListarUsuariosDoSistema() throws Exception {
//
//		UsuarioSistemaDAO dao = new UsuarioSistemaDAO();
//		System.out.println(dao.listaUsuarioSistema());
//
//	}
//
//	@Test
//	public void ListarUsuarioDoSistema() throws Exception {
//
//		UsuarioSistemaDAO dao = new UsuarioSistemaDAO();
//		System.out.println(dao.buscaUsuarioUser("admin"));
//
//	}
//
//	@Test
//	public void ListaClienteID() throws Exception {
//
//		ClienteDAO dao = new ClienteDAO();
//		Cliente cliente = null;
//		cliente = dao.buscaClienteId(2L);
//		System.out.println(cliente);
//
//
//	}


//	@Test
//	public void AlterarCliente() throws Exception {
//
//		ClienteDAO dao = new ClienteDAO();
//		Cliente cliente = dao.buscaClienteId(2L);
//
//
//		cliente.setNome("Tiago Fernandes11");
//		//System.out.println(client);
//
//
//
//		dao.alteraCliente(cliente);
//
//
//	}


//	@Test
//	public void data() throws Exception {
//
////		ClienteDAO dao = new ClienteDAO();
////		Cliente cliente = new Cliente();
////
////		cliente.setNome("Linux");
////		cliente.setDocumento("888.888.888-09");
////		cliente.setEmail("linux@admin");
////		cliente.setDataCriacao("datetime('now','localtime')");
////		dao.novoCliente(cliente);
//
//		DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now);
//		System.out.println(newFormat.format(now));
//
//	}


	@Test
	public void ListaClienteDoc() throws Exception {

		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = null;
		cliente = dao.buscaClienteDocumento("777.777.777-77");
		System.out.println(cliente.getNome());


	}










//	@Test
//	public void List() throws Exception {
//
//		SistemaUserDAO dao = new SistemaUserDAO();
//		System.out.println("Listar Usuários");
//		System.out.println(dao.listaUsuarioSistema());
//
//	}
//
//	@Test
//	public void buscaId() throws Exception {
//		SistemaUserDAO dao = new SistemaUserDAO();
//		System.out.println("Listar por ID");
//		System.out.println(dao.buscaUsuarioSistemaId(1L));
//
//	}
//
//	@Test
//	public void buscaNome() throws Exception {
//		SistemaUserDAO dao = new SistemaUserDAO();
//		System.out.println("Listar por Nome");
//		System.out.println(dao.buscaUsuarioSistemaNome("Tiago"));
//
//	}
//
//	@Test
//	public void buscaUser() throws Exception {
//		SistemaUserDAO dao = new SistemaUserDAO();
//		System.out.println("Listar por User");
//		System.out.println(dao.buscaUsuarioSistemaNome("admin"));



}
