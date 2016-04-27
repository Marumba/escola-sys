<%-- 
    Document   : reg.jsp
    Created on : Apr 26, 2016, 2:41:27 AM
    Author     : Marumba
--%>

<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
String login=request.getParameter("login"); 
session.putValue("login",login); 
String senha=request.getParameter("senha"); 
String nome=request.getParameter("nome"); 
Class.forName("com.mysql.jdbc.Driver"); 
java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola",
"root",""); 
Statement st= con.createStatement(); 
ResultSet rs; 
int i = st.executeUpdate("insert into usuarios values ('adm','"+nome+"','"+login+"','"+senha+"')"); 

%>
