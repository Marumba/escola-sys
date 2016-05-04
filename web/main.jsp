<%-- 
    Document   : main
    Created on : May 3, 2016, 1:05:56 AM
    Author     : Marumba
--%>

<%@ page import="CRUD.controller.MainController" language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
    <head>
        <title>Interno - Cursos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
	    <link href="css/style.css" rel="stylesheet" />
	    <script src="js/jquery-1.12.3.min.js"></script>
	    <script src="lib/bootstrap/js/bootstrap.min.js"></script>
	    <script src="js/global.js"></script>
    </head>

    <body>
        <div class="container-fluid">
        <div class="col-xs-12 cursos-tab-container">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 cursos-tab-menu">
              <div class="list-group">
                <a href="#" class="list-group-item active text-center">
                  <h4 class="glyphicon glyphicon-user"></h4><br/>Alunos
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-education"></h4><br/>Cursos
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-book"></h4><br/>Turmas
                </a> 
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-briefcase"></h4><br/>Professores
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-search"></h4><br/>Consultas
                </a>
                <a href="#" class="list-group-item text-center">
                  <h4 class="glyphicon glyphicon-calendar"></h4><br/>Matrículas
                </a>
              </div>
            </div>
            <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9 cursos-tab">

                <div class="cursos-tab-content active">
                     <h1 class="text-center">Alunos: <c:out value="${aluno}" /></h1>
                    <form class="form-horizontal" method="POST" action='AlunoController' name="frmAddAluno">
                      <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="rg" class="col-sm-2 control-label">RG</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="rg" name="rg" placeholder="RG">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="cpf" class="col-sm-2 control-label">CPF</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                          <button type="submit" class="btn btn-success">Cadastrar</button>
                          <a href="AlunoController?action=listarAluno" class="btn btn-default">Ver todos os Alunos</a>
                        </div>
                      </div>
                    </form>
                </div>

                <div class="cursos-tab-content">
                   <h1 class="text-center">Cursos: <c:out value="${curso}" /></h1>
                    <form class="form-horizontal" method="POST" action='CursoController' name="frmAddCurso">
                      <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="area" class="col-sm-2 control-label">Área</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="area" name="area" placeholder="Área">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                          <button type="submit" class="btn btn-success">Cadastrar</button>
                          <a href="CursoController?action=listarCurso" class="btn btn-default">Ver todos os Cursos</a>
                        </div>
                      </div>
                    </form>
                  
                </div>
                <div class="cursos-tab-content">
                  <h1 class="text-center">Turmas: <c:out value="${turma}" /></h1>
                    <form class="form-horizontal" method="POST" action='TurmaController' name="frmAddTurma">
                      <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome</label>
                        <div class="col-sm-9">
                          <input type="text" readonly="readonly" class="form-control" id="nome" name="nome" value="A<c:out value="${ultimaTurma+1}" />/2016" />
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="periodo" class="col-sm-2 control-label">Período</label>
                        <div class="col-sm-9">
                          <div class="col-sm-4">
                            <label>
                              <input type="checkbox" name="periodo" value="Matutino"> Matutino
                            </label> 
                          </div>
                          <div class="col-sm-4">
                            <label>
                              <input type="checkbox" name="periodo" value="Vespertino"> Vespertino
                            </label> 
                          </div>
                          <div class="col-sm-4">
                            <label>
                              <input type="checkbox" name="periodo" value="Noturno"> Noturno
                            </label>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                          <button type="submit" class="btn btn-success">Cadastrar</button>
                          <a href="TurmaController?action=listarTurma" class="btn btn-default">Ver todos os Turmas</a>
                        </div>
                      </div>
                    </form>
                  
                </div>

                <div class="cursos-tab-content">
                   <h1 class="text-center">Professores: <c:out value="${professor}" /></h1>
                    <form class="form-horizontal" method="POST" action='ProfessorController' name="frmAddProfessor">
                      <div class="form-group">
                        <label for="nome" class="col-sm-2 control-label">Nome</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="rg" class="col-sm-2 control-label">RG</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="rg" name="rg" placeholder="RG">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="cpf" class="col-sm-2 control-label">CPF</label>
                        <div class="col-sm-9">
                          <input type="text" class="form-control" id="cpf" name="cpf" placeholder="CPF">
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                          <button type="submit" class="btn btn-success">Cadastrar</button>
                          <a href="ProfessorController?action=listarProfessor" class="btn btn-default">Ver todos os Professores</a>
                        </div>
                      </div>
                    </form>
                </div>

                <div class="cursos-tab-content">
                  <h1 class="text-center">Consultas</h1>
                  
                </div>  

                <div class="cursos-tab-content">
                  <h1 class="text-center">Matrículas: <c:out value="${matricula}" /></h1>
                  <form class="form-horizontal" method="POST" action='MatriculaController' name="frmAddMatricula">
                   <div class="form-group">
                        <label for="aluno" class="col-sm-2 control-label">Aluno</label>
                        <div class="col-sm-9">
                              <select class="form-control" name="aluno" id="aluno">
                          <c:forEach items="${alunos}" var="aluno">
                                  <option value="<c:out value="${aluno.ra}" />"><c:out value="${aluno.nome}" /></option>
                          </c:forEach>
                              </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="curso" class="col-sm-2 control-label">Curso</label>
                        <div class="col-sm-9">
                              <select class="form-control" name="curso" id="curso">
                          <c:forEach items="${cursos}" var="curso">
                                  <option value="<c:out value="${curso.cod}" />"><c:out value="${curso.nome}" /> - <c:out value="${curso.area}" /></option>
                          </c:forEach>
                              </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="turma" class="col-sm-2 control-label">Turma</label>
                        <div class="col-sm-9">
                              <select class="form-control" name="turma" id="turma">
                          <c:forEach items="${turmas}" var="turma">
                                  <option value="<c:out value="${turma.cod}" />"><c:out value="${turma.nome}" /> - <c:out value="${turma.periodo}" /></option>
                          </c:forEach>
                              </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="professor" class="col-sm-2 control-label">Professor</label>
                        <div class="col-sm-9">
                              <select class="form-control" name="professor" id="professor">
                          <c:forEach items="${professores}" var="professor">
                                  <option value="<c:out value="${professor.rp}" />"><c:out value="${professor.nome}" /></option>
                          </c:forEach>
                              </select>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                          <button type="submit" class="btn btn-success">Cadastrar</button>
                          <a href="MatriculaController?action=listarMatricula" class="btn btn-default">Ver todas as Matriculas</a>
                        </div>
                      </div>
                    </form>
                </div>
            </div>
        </div>
	</div>
    </body>
</html>

