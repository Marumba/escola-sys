<%-- 
    Document   : listarUsuario
    Created on : Apr 27, 2016, 3:49:50 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.AlunoController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Alunoa</title>
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
            <h1 class="text-center">Listar Alunos</h1> 
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>RA</th>
                        <th>Nome</th>
                        <th>RG</th>
                        <th>CPF</th>
                        <th colspan=2>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alunos}" var="aluno">
                        <tr>
                            <td><c:out value="${aluno.ra}" /></td>
                            <td><c:out value="${aluno.nome}" /></td>
                            <td><c:out value="${aluno.rg}" /></td>
                            <td><c:out value="${aluno.cpf}" /></td>
                            <td><a href="AlunoController?action=edit&userId=<c:out value="${aluno.ra}"/>">Update</a></td>
                            <td><a href="AlunoController?action=delete&userId=<c:out value="${aluno.ra}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="MainController" class="btn btn-default">Adicionar Aluno</a>
        </div>
    </div>
   
</body>
</html>
