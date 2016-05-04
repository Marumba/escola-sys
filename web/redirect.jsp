<%-- 
    Document   : redirect
    Created on : Apr 27, 2016, 3:48:56 AM
    Author     : Marumba
--%>

<%@page import="CRUD.controller.MainController" language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Redirect</title>
</head>
<body>
<jsp:forward page="/MainController?action=redirect" />
</body>
</html>