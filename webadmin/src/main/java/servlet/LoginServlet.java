package servlet;

import java.io.IOException;

import database.UsuarioSistemaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.UsuarioSistema;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		if (usuario != null && senha != null && !usuario.isEmpty() && !senha.isEmpty()) {

			try {
				UsuarioSistema u = new UsuarioSistemaDAO().buscaUsuarioUser(usuario);

				if (usuario.equals(u.getLogin()) && senha.equals(u.getSenha())) {

					HttpSession session = req.getSession();
					session.setAttribute("usuarioLogado", u);
					RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
					rd.forward(req, resp);

				} else {

					req.setAttribute("erro", "Usuario/senha incorretos");
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			req.setAttribute("erro", "Usuario/senha incorretos");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

	}

}
