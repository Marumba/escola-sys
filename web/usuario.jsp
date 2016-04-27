<%-- 
    Document   : usuario
    Created on : Apr 27, 2016, 4:12:32 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.UsuarioController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add new user</title>
</head>
<body>

    <form method="POST" action='UsuarioController' name="frmAddUser">
        ID : <input type="text" readonly="readonly" name="id"
            value="<c:out value="${usuario.id}" />" /> <br /> 
        Função : <input type="text" name="funcao" value="<c:out value="${usuario.funcao}" />" /> <br /> 
        Nome : <input type="text" name="nome" value="<c:out value="${usuario.nome}" />" /> <br /> 
        Entrada : <input type="text" name="entrada" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${usuario.entrada}" />" /> <br /> 
        Email : <input type="text" name="email" value="<c:out value="${usuario.email}" />" />    
        Senha : <input type="password" name="senha" value="<c:out value="${usuario.senha}" />" /> 
        
        <br /> <input type="submit" value="Submit" />
    </form>
</body>
</html>
