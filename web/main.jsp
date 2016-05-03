<%-- 
    Document   : main
    Created on : May 3, 2016, 1:05:56 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.AlunoController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Interno - Cursos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="css/style.css" rel="stylesheet" />
	    <script src="js/jquery-1.12.3.min.js"></script>
	    <script src="lib/bootstrap/js/bootstrap.min.js"></script>
	    <script src="js/global.js"></script>
    </head>

    <body>
        <div class="container-fluid">
        <div class="col-xs-12 cursos-tab-container">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 cursos-tab-menu">
              <div class="list-group">
                <a href="#" class="list-group-item active text-center">
                  <h4 class="glyphicon glyphicon-user"></h4><br/>Alunos
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-briefcase"></h4><br/>Professores
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-group"></h4><br/>Turmas
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-education"></h4><br/>Cursos
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-search"></h4><br/>Consultas
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-calendar"></h4><br/>Relatórios
                </a>
              </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 cursos-tab">

                <div class="cursos-tab-content active">
                    <center>
                      <h1>Alunos</h1>
                      <h2>Cadastrados: <c:out value="${aluno}" /></h2>
                    </center>
  <form class="form-horizontal" method="POST" action='AlunoController' name="frmAddAluno">
    <div class="form-group">
      <label for="nome" class="col-sm-2 control-label">Nome</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
      </div>
    </div>
    <div class="form-group">
      <label for="rg" class="col-sm-2 control-label">RG</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="rg" name="rg" placeholder="RG">
      </div>
    </div>
    <div class="form-group">
      <label for="cpf" class="col-sm-2 control-label">CPF</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-5">
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <a href="UsuarioController?action=listarAluno" class="btn btn-default">Ver todos os Alunos</a>
      </div>
    </div>
  </form>
<p></p>

                </div>

                <div class="cursos-tab-content">
                    <center>
                      <h1>Professores</h1>
                    </center>
                </div>
    
                <div class="cursos-tab-content">
                    <center>
                      <h1>Turmas</h1>
                    </center>
                </div>

                <div class="cursos-tab-content">
                    <center>
                      <h1>Cursos</h1>
                    </center>
                </div>

                <div class="cursos-tab-content">
                    <center>
                      <h1>Consultas</h1>
                    </center>
                </div>  

                <div class="cursos-tab-content">
                    <center>
                      <h1>Relatórios</h1>
                    </center>
                </div>
            </div>
        </div>
	</div>
    </body>
</html>

