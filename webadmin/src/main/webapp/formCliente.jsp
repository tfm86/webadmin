<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List,modelo.Cliente"%>
<%@page import="modelo.UsuarioSistema"%>

<% 
  String erro = (String) request.getAttribute("erro");
%>

<% 
  String erro2 = (String) request.getAttribute("erro2");
%>

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
        <a class="navbar-brand text-warning bg-dark" href="formCliente.jsp">Cadastro</a>
     
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
<h2>Cadastro do Cliente</h2>


	<form class="mx-auto" action="/webadmin/novoCliente" method="post">

		Nome: <input type="text" name="nome"/>
		
    Documento: <input type="text" name="documento" placeholder="xxx.xxx.xxx-xx"/>
    <div class="form-floating">
				<p>
					<% 
              		if (erro != null) {
                		out.println(erro);
              		} 
          	   		%>
				</p>
			</div>
    
		Email: <input type="text" name="email"/>
		
    <br>
		<button class="btn btn-primary w-50 py-2" type="submit">Cadastrar</button>
     <div class="form-floating">
				<p>
					<% 
              		if (erro2 != null) {
                		out.println(erro2);
              		} 
          	   		%>
				</p>
			</div>

	</form>

</div>




    


<script src="js/bootstrap.min.js"></script>
</body>

</html>