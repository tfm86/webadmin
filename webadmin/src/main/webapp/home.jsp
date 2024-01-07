<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="modelo.UsuarioSistema"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/styles.css"/>
    <title>WebAdmin - Home</title>
</head>

  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    
    <ul class="navbar-nav me-auto mb-2 mb-md-0">
      
      <li class="nav-item">
        
        <a class="navbar-brand text-warning bg-dark" href="home.jsp">Home</a>
        <a class="navbar-brand" href="/webadmin/listaCliente">Cliente</a>
     
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

<body>


    


<script src="js/bootstrap.min.js"></script>
</body>

</html>