<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List,modelo.Cliente"%>
<%@page import="modelo.UsuarioSistema"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>WebAdmin - Cadastro Cliente</title>
</head>

<body>

  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <ul class="navbar-nav me-auto mb-2 mb-md-0">
      
      <li class="nav-item">
        
        <a class="navbar-brand" href="home.jsp">Home</a>
        <a class="navbar-brand" href="/webadmin/listaCliente">Cliente</a>
        <a class="navbar-brand text-warning bg-dark" href="cadastro.jsp">Cadastro</a>
     
      </li>
      
    </ul>

    <ul class="navbar-nav mb-2 mb-md-0">
      <li class="nav-item">
        <a class="navbar-brand" aria-disabled="true">
        
           <%
            UsuarioSistema u = (UsuarioSistema) session.getAttribute("usuarioLogado");
              if(u != null){
                out.println(u.getLogin());
              }
            %>
        
        </a>
        <a class="navbar-brand" aria-disabled="true" href="logoutServlet">Sair</a>
     </li>
    
    </ul>

  
  </nav>


<div class="container">
<h2>Atualização</h2>


    <%
      @SuppressWarnings("unchecked")
        Cliente cliente = (Cliente) request.getAttribute("cliente");
	%>
  


	<form class="mx-auto" action="/webadmin/alterarCliente" method="post">

		Nome: <input type="text" name="nome" value="<% out.println(cliente.getNome()); %>" />
		Documento: <input type="text" name="documento" value="<% out.println(cliente.getDocumento()); %>" />
		Email: <input type="text" name="email" value="<% out.println(cliente.getEmail()); %>" />
		<fieldset disabled>
		Data Criação: <input type="text" name="dataCriacao" value="<% out.println(cliente.getDataCriacao()); %>" />
		</fieldset>

		<input type="hidden" name="id" value=<% out.println(cliente.getId()); %>>

		<button class="btn btn-primary w-50" type="submit">Atualizar</button>


	</form>

</div>




    


<script src="js/bootstrap.min.js"></script>
</body>

</html>