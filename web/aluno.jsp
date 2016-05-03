<%-- 
    Document   : usuario
    Created on : Apr 27, 2016, 4:12:32 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.AlunoController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add new user</title>
</head>
<body>

    <form method="POST" action='AlunoController' name="frmAddAluno">
        ID : <input type="text" readonly="readonly" name="ra" value="<c:out value="${usuario.ra}" />" /> <br /> 
        Nome : <input type="text" name="nome" value="<c:out value="${usuario.nome}" />" /> <br /> 
        RG : <input type="text" name="rg" value="<c:out value="${usuario.rg}" />" />   <br />  
        CPF : <input type="password" name="cpf" value="<c:out value="${usuario.cpf}" />" /> 
        
        <br /> <input type="submit" value="Submit" />
    </form>
</body>
</html>
