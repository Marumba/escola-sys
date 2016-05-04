<%-- 
    Document   : usuario
    Created on : Apr 27, 2016, 4:12:32 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.MatriculaController" language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Editar Matricula</title>

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
            <h1 class="text-center">Editar Matricula</h1> 
            <form class="form-horizontal" method="POST" action='MatriculaController' name="frmAddMatricula">
                <input type="hidden" name="cod" value="<c:out value="${matricula.cod}" />" />
              <div class="form-group">
                <label for="curso" class="col-sm-2 control-label">Curso</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="curso" name="curso" value="<c:out value="${matricula.curso}" />">
                </div>
              </div>
              <div class="form-group">
                <label for="turma" class="col-sm-2 control-label">Turma</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="turma" name="turma" value="<c:out value="${matricula.turma}" />">
                </div>
              </div> 
              <div class="form-group">
                <label for="professor" class="col-sm-2 control-label">Professor</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="professor" name="professor" value="<c:out value="${matricula.professor}" />">
                </div>
              </div> 
              <div class="form-group">
                <label for="aluno" class="col-sm-2 control-label">Aluno</label>
                <div class="col-sm-9">
                  <input type="text" class="form-control" id="aluno" name="aluno" value="<c:out value="${matricula.aluno}" />">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                  <button type="submit" class="btn btn-success">Salvar</button>
                  <a href="MatriculaController?action=listarMatricula" class="btn btn-default">Ver todas as Matriculas</a>
                </div>
              </div>
            </form>
        </div>
    </div>
</body>
</html>
