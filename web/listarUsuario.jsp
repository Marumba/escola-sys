<%-- 
    Document   : listarUsuario
    Created on : Apr 27, 2016, 3:49:50 AM
    Author     : Marumba
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Usuários</title>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Id</th>
                <th>Função</th>
                <th>Nome</th>
                <th>Data de entrada</th>
                <th>Email</th>
                <th colspan=2>Ação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.id}" /></td>
                    <td><c:out value="${usuario.funcao}" /></td>
                    <td><c:out value="${usuario.nome}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${usuario.entrada}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><a href="UsuarioController?action=edit&userId=<c:out value="${usuario.id}"/>">Update</a></td>
                    <td><a href="UsuarioController?action=delete&userId=<c:out value="${usuario.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="UsuarioController?action=insert">Adicionar Usuário</a></p>
</body>
</html>