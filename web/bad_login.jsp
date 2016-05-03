<%-- 
    Document   : login
    Created on : Apr 26, 2016, 2:04:22 AM
    Author     : Marumba
--%>

<%@page import="CRUD.UsuarioController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login - Escola</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	<link href="css/style.css" rel="stylesheet" />
	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="lib/bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Erro no login</h1>
                    <p>Seu Usuário / Senha não estão corretos, tente novamente clicando <a href="index.jsp"> aqui</a></p>
                </div>
            </div>
        </div>
    </body>
</html>
