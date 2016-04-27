<%-- 
    Document   : redirect
    Created on : Apr 27, 2016, 3:48:56 AM
    Author     : Marumba
--%>

<%@page import="CRUD.UsuarioController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:forward page="/UsuarioController?action=listarUsuario" />
</body>
</html>