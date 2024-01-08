<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List,modelo.Cliente"%>
<%@page import="modelo.UsuarioSistema"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>WebAdmin - Clientes</title>
</head>

<body>

  <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <ul class="navbar-nav me-auto mb-2 mb-md-0">
      
      <li class="nav-item">
        
        <a class="navbar-brand" href="home.jsp">Home</a>
        <a class="navbar-brand text-warning bg-dark" href="/webadmin/listaCliente">Cliente</a>
        <a class="navbar-brand" href="formCliente.jsp">Cadastro</a>
     
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
<h2>Lista de Clientes</h2>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Documento</th>
      <th scope="col">Email</th>
      <th scope="col">Data Cadastro</th>
    </tr>
  </thead>
  <tbody>
    
  <%
      @SuppressWarnings("unchecked")
                List<Cliente> lista = (List<Cliente>) request.getAttribute("clientes");
      %>
  
    <%
    for(Cliente cliente: lista){
    %>

     
     <tr>
      <th scope="row"><% out.println(cliente.getId()); %></th> 
      <td><% out.println(cliente.getNome()); %></td>
      <td><% out.println(cliente.getDocumento()); %></td>
      <td><% out.println(cliente.getEmail()); %></td>
      <td><% out.println(cliente.getDataCriacao()); %></td>
      <td><a href="/webadmin/mostrarCliente?id=<% out.println(cliente.getId()); %>" type="button" class="btn btn-primary">Atualizar</a></td>
      <td><a href="/webadmin/removeCliente?id=<% out.println(cliente.getId()); %>" type="button" class="btn btn-danger">Deletar</a></td>
    </tr>
    
    
  <%
    }
  %> 
   
  
  
  </tbody>
</table>

</div>




    


<script src="js/bootstrap.min.js"></script>
</body>

</html>