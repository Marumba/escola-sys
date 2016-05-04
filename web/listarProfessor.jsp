<%-- 
    Document   : listarUsuario
    Created on : Apr 27, 2016, 3:49:50 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.ProfessorController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Professores</title>
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
            <h1 class="text-center">Listar Professores</h1> 
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>RP</th>
                        <th>Nome</th>
                        <th>RG</th>
                        <th>CPF</th>
                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${professores}" var="professor">
                        <tr>
                            <td><c:out value="${professor.rp}" /></td>
                            <td><c:out value="${professor.nome}" /></td>
                            <td><c:out value="${professor.rg}" /></td>
                            <td><c:out value="${professor.cpf}" /></td>
                            <td><a href="ProfessorController?action=edit&userId=<c:out value="${professor.rp}"/>">Update</a></td>
                            <td><a href="ProfessorController?action=delete&userId=<c:out value="${professor.rp}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="MainController" class="btn btn-default">Adicionar Professor</a>
        </div>
    </div>
   
</body>
</html>
