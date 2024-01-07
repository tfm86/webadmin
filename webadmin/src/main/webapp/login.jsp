<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
  String erro = (String) request.getAttribute("erro");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/styles.css" />
<title>WebAdmin - Login</title>
</head>

<body>

	<div class="container-fluid">

		<form class="mx-auto" action="loginServlet" method="post">
			<h1>Login</h1>
			<div class="form-floating mb-2">
				<input type="text" name="usuario" class="form-control"
					id="floatingInput" placeholder="usuario"> <label
					for="floatingInput">Usuário</label>
			</div>
			<div class="form-floating">
				<input type="password" name="senha" class="form-control"
					id="floatingPassword" placeholder="senha"> <label
					for="floatingPassword">Senha</label>
			</div>

			<br>
			<button class="btn btn-primary w-100 py-2" type="submit">Entrar</button>
			<p>&copy; 2023</p>

			<div class="form-floating">
				<p>
					<% 
              		if (erro != null) {
                		out.println(erro);
              		} 
          	   		%>
				</p>
			</div>

		</form>

	</div>



	<script src="js/bootstrap.min.js"></script>
</body>

</html>