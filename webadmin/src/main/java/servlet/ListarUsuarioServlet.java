package servlet;

import java.io.IOException;
import java.util.List;

import database.ClienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

@WebServlet(urlPatterns = "/listaCliente")
public class ListarUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	ClienteDAO dao = new ClienteDAO();
	List<Cliente> listaCliente = null;

	try {
		listaCliente = dao.listaClienteSistema();
		dao.CloseConnect();
	} catch (Exception e) {
		e.printStackTrace();
	}

	RequestDispatcher rd = req.getRequestDispatcher("cliente.jsp");
	req.setAttribute("clientes", listaCliente);
	rd.forward(req, resp);

	}

}
