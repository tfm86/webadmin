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

@WebServlet(urlPatterns = "/mostrarCliente")
public class MostrarClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId = req.getParameter("id");
		Long id = Long.parseLong(paramId);
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = null;

		try {
			cliente = dao.buscaClienteId(id);
			dao.CloseConnect();
		} catch (Exception e) {

			req.setAttribute("erro", "Usuário não encontrado");
			e.printStackTrace();
		}

		req.setAttribute("cliente", cliente);

		RequestDispatcher rd = req.getRequestDispatcher("/formAlteraCliente.jsp");
		rd.forward(req, resp);

	}

}
