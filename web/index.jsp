<%-- 
    Document   : index
    Created on : May 3, 2016, 12:18:26 AM
    Author     : Marumba
--%>

<%@page import="CRUD.controller.MainController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1 class="text-center login-title">Entre com seu usuário</h1>
                    <div class="account-wall">
                        <span class="glyphicon glyphicon-user profile-img"></span>
                        <form method="POST" class="form-signin" action="MainController">
                        <input type="text" name="user" class="form-control" placeholder="Usuário" required autofocus>
                        <input type="password" name="pass" class="form-control" placeholder="Senha" required>
                        <input type="hidden" name="action" value="logar" />
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Entrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
