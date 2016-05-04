<%-- 
    Document   : usuario
    Created on : Apr 27, 2016, 4:12:32 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.CursoController" language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Curso</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.12.3.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container">
        <div class="row">
            <h1 class="text-center">Editar Curso</h1> 
            <form class="form-horizontal" method="POST" action='CursoController' name="frmAddCurso">
                <input type="hidden" name="cod" value="<c:out value="${curso.cod}" />" />
              <div class="form-group">
                <label for="nome" class="col-sm-2 control-label">Nome</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="nome" name="nome" value="<c:out value="${curso.nome}" />">
                </div>
              </div>
              <div class="form-group">
                <label for="area" class="col-sm-2 control-label">Área</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="area" name="area" value="<c:out value="${curso.area}" />">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-success">Salvar</button>
                  <a href="CursoController?action=listarCurso" class="btn btn-default">Ver todos os Cursos</a>
                </div>
              </div>
            </form>
        </div>
    </div>
</body>
</html>
