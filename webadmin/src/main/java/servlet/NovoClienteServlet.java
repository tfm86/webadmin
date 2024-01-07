package servlet;

import java.io.IOException;

import database.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ConvertData;

@WebServlet(urlPatterns = "/novoCliente")
public class NovoClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String documento = req.getParameter("documento");
		String email = req.getParameter("email");

		if (nome != null && documento != null && email != null && !nome.isEmpty() && !documento.isEmpty()
				&& !email.isEmpty()) {

			ClienteDAO dao = new ClienteDAO();

			try {
				Cliente clienteExite = dao.buscaClienteDocumento(documento);
				if (clienteExite.getDocumento() == null) {

					Cliente cliente = new Cliente();
					cliente.setNome(nome);
					cliente.setDocumento(documento);
					cliente.setEmail(email);
					cliente.setDataCriacao(new ConvertData().getDataHora());
					dao.novoCliente(cliente);
					dao.CloseConnect();
					resp.sendRedirect("listaCliente");

				}else {

					req.setAttribute("erro", "documento já existe");
					RequestDispatcher rd = req.getRequestDispatcher("formCliente.jsp");
					rd.forward(req, resp);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			req.setAttribute("erro2", "dados não preenchidos");
			RequestDispatcher rd = req.getRequestDispatcher("formCliente.jsp");
			rd.forward(req, resp);

		}

	}

}
