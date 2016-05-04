<%-- 
    Document   : usuario
    Created on : Apr 27, 2016, 4:12:32 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.ProfessorController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Professor</title>

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
            <h1 class="text-center">Editar Professor</h1> 
            <form class="form-horizontal" method="POST" action='ProfessorController' name="frmAddProfessor">
                <input type="hidden" name="ra" value="<c:out value="${professor.rp}" />" />
              <div class="form-group">
                <label for="nome" class="col-sm-2 control-label">Nome</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${professor.nome}" />">
                </div>
              </div>
              <div class="form-group">
                <label for="rg" class="col-sm-2 control-label">RG</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="rg" name="rg" value="<c:out value="${professor.rg}" />">
                </div>
              </div>
              <div class="form-group">
                <label for="cpf" class="col-sm-2 control-label">CPF</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="cpf" name="cpf" value="<c:out value="${professor.cpf}" />" />
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-success">Salvar</button>
                  <a href="ProfessorController?action=listarProfessor" class="btn btn-default">Ver todos os Professores</a>
                </div>
              </div>
            </form>
        </div>
    </div>
</body>
</html>
