<%-- 
    Document   : listarUsuario
    Created on : Apr 27, 2016, 3:49:50 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.TurmaController" language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Turmas</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<script src="js/jquery-1.12.3.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <h1 class="text-center">Listar Turmas</h1> 
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Nome</th>
                        <th>Período</th>
                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${turmas}" var="turma">
                        <tr>
                            <td><c:out value="${turma.cod}" /></td>
                            <td><c:out value="${turma.nome}" /></td>
                            <td><c:out value="${turma.periodo}" /></td>
                            <td><a href="TurmaController?action=edit&userId=<c:out value="${turma.cod}"/>">Update</a></td>
                            <td><a href="TurmaController?action=delete&userId=<c:out value="${turma.cod}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="MainController" class="btn btn-default">Adicionar Turma</a>
        </div>
    </div>
   
</body>
</html>
