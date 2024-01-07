package servlet;
import java.io.IOException;

import database.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;

@WebServlet(urlPatterns = "/alterarCliente")
public class AlterarClienteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramNome = req.getParameter("nome");
		String paramDocumento = req.getParameter("documento");
		String paramEmail = req.getParameter("email");
		//String parameDataCriacao = req.getParameter("dataCriacao");
		String paramId = req.getParameter("id");
		Long id = Long.parseLong(paramId);


		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = null;


		try {
			cliente = dao.buscaClienteId(id);
			cliente.setNome(paramNome);
			cliente.setDocumento(paramDocumento);
			cliente.setEmail(paramEmail);
			dao.alteraCliente(cliente);
			dao.CloseConnect();

		} catch (Exception e) {
			e.printStackTrace();
		}


		resp.sendRedirect("listaCliente");

	}


}
