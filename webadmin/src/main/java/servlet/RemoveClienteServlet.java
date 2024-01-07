package servlet;
import java.io.IOException;
import java.sql.SQLException;

import database.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/removeCliente")
public class RemoveClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramId = req.getParameter("id");
		Integer id = Integer.parseInt(paramId);

		ClienteDAO dao = new ClienteDAO();
		dao.deleteCliente(id);

		try {
			dao.CloseConnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		resp.sendRedirect("listaCliente");

	}


}
